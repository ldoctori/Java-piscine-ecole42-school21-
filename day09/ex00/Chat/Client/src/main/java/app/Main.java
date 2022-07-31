package app;


import client.Client;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

import java.io.IOException;

@Parameters(separators = "=")
public class Main {

    @Parameter(names = {"--server-port", "-sp"})
    private static int port;

    public static void main(String[] args) throws IOException, InterruptedException {

        JCommander.newBuilder()
                .addObject(new Main())
                .build()
                .parse(args);
        Client client = new Client(port);

    }

}
