package school21.spring.service.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import school21.spring.service.repositories.UsersRepositoryJdbcImpl;
import school21.spring.service.repositories.UsersRepositoryJdbcTemplate;
import school21.spring.service.services.UsersServiceImpl;


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
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl(properties.getProperty("db.url"));
        hikariDataSource.setUsername(properties.getProperty("db.user"));
        hikariDataSource.setPassword(properties.getProperty("db.password"));
        hikariDataSource.setDriverClassName(properties.getProperty("db.driver.name"));

        return hikariDataSource;
    }

    @Bean
    public DriverManagerDataSource getDMDS() throws IOException {

        DriverManagerDataSource dMdS = new DriverManagerDataSource();
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        dMdS.setUrl(properties.getProperty("db.url"));
        dMdS.setUsername(properties.getProperty("db.user"));
        dMdS.setPassword(properties.getProperty("db.password"));
        dMdS.setDriverClassName(properties.getProperty("db.driver.name"));

        return dMdS;
    }

    @Bean
    public UsersRepositoryJdbcImpl usersRepositoryJdbc() throws SQLException {
        return new UsersRepositoryJdbcImpl();
    }

    @Bean
    public UsersRepositoryJdbcTemplate usersRepositoryJdbcTemplate() throws SQLException {
        return new UsersRepositoryJdbcTemplate();
    }

    @Bean
    public UsersServiceImpl usersServiceImpl() {
        return new UsersServiceImpl();
    }
}

