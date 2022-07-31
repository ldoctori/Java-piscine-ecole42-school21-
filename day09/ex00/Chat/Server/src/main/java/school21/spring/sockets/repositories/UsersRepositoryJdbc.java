package school21.spring.sockets.repositories;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component
public class UsersRepositoryJdbc implements UsersRepository{

    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(HikariDataSource hikariDataSource) {
        this.jdbcTemplate = new JdbcTemplate(hikariDataSource);
    }

   public JdbcTemplate getJdbcTemplate() {
        return this.jdbcTemplate;
    }
}
