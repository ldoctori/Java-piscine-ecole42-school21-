package school21.spring.sockets.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import school21.spring.sockets.models.User;
import school21.spring.sockets.repositories.UsersRepository;
import school21.spring.sockets.services.UsersService;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

@Component
public class Server {

    private int port;
    private static Server instance;
    private Socket clientSocket;
    private ServerSocket server;
    private BufferedWriter out;
    private BufferedReader in;
    UsersService usersService;

    private Server() {}

    public static Server getServer() {
        if (instance == null) {
            instance = new Server();
        }
        return instance;
    }

    public void runServer(int port) throws IOException, InterruptedException {
        server = new ServerSocket(port, 1);
        System.out.println("Server is run.");
        clientSocket = server.accept();
        System.out.println("Accepted new client.");
        this.out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        this.in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out.write("Hello from server!\n");
        out.flush();

        String line = in.readLine();
        while (!line.equals("signUp")) {
            out.write("I know only 'signUp' command.\n");
            out.flush();
            line = in.readLine();
        }
        out.write("ok\n");
        out.flush();
        out.write(signUp());
        out.flush();
        clientSocket.close();
        in.close();
        out.close();

    }

    private String signUp() throws IOException {

        out.write("Enter username:\n");
        out.flush();
        String username = in.readLine();
        out.write("Enter password:\n");
        out.flush();
        String password = in.readLine();

        return usersService.signUp(new User(username, password));
    }

    @Autowired
    @Qualifier("usersServiceImpl")
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }
}
