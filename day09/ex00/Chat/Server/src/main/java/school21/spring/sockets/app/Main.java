package school21.spring.sockets.app;


import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import school21.spring.sockets.repositories.UsersRepositoryJdbc;
import school21.spring.sockets.server.Server;

import java.io.IOException;

@Parameters(separators = "=")
public class Main {

    @Parameter(names = {"--port", "-p"})
    private static int port;

    public static void main(String[] args) throws IOException, InterruptedException {

        JCommander.newBuilder()
                .addObject(new Main())
                .build()
                .parse(args);

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(school21.spring.sockets.config.ApplicationConfig.class);
        JdbcTemplate jdbcTemplate = context.getBean("usersRepositoryJdbcTemplate", UsersRepositoryJdbc.class).getJdbcTemplate();
        jdbcTemplate.update("CREATE TABLE IF NOT EXISTS users (id SERIAL PRIMARY KEY, name VARCHAR(100), password VARCHAR(100))", new Object[]{});
        Server server = context.getBean("getServer", Server.class);
        server.runServer(port);
    }
}
