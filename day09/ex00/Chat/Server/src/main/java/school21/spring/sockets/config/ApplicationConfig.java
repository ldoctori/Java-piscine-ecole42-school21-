package school21.spring.sockets.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.hibernate.HikariConnectionProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import school21.spring.sockets.repositories.UsersRepositoryJdbc;
import school21.spring.sockets.server.Server;
import school21.spring.sockets.services.UsersServiceImpl;


import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

@Configuration
@ComponentScan("school21.spring.service.repositories.*")
public class ApplicationConfig {

    @Bean
    public HikariDataSource getHDS() throws IOException {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl(properties.getProperty("db.url"));
        ds.setUsername(properties.getProperty("db.user"));
        ds.setPassword(properties.getProperty("db.password"));
        ds.setDriverClassName(properties.getProperty("db.driver.name"));

        return ds;
    }

    @Bean
    public UsersRepositoryJdbc usersRepositoryJdbcTemplate() throws SQLException {
        return new UsersRepositoryJdbc();
    }

    @Bean
    public UsersServiceImpl usersServiceImpl() {
        return new UsersServiceImpl();
    }

    @Bean
    public Server getServer() {
        return Server.getServer();
    }
}

