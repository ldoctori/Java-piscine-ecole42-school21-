package school21.spring.service.repositories;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import school21.spring.service.models.User;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

public class UsersRepositoryJdbcTemplate implements UsersRepository{

    JdbcTemplate jdbcTemplate;
    public UsersRepositoryJdbcTemplate(DriverManagerDataSource driverManagerDataSource) {

        this.jdbcTemplate = new JdbcTemplate(driverManagerDataSource);
    }

    @Override
    public Optional<User> findById(Long id) {

        return Optional.ofNullable(this.jdbcTemplate.query("SELECT * FROM users WHERE id=?", new Object[]{id}, (rs, rowNum) -> new User(rs.getLong(1), rs.getString(2))).get(0));
    }

    @Override
    public List<User> findAll() {

        return this.jdbcTemplate.query("SELECT * FROM users", (rs, rowNum) -> new User(rs.getLong(1), rs.getString(2)));
    }

    @Override
    public void save(User entity) {
        this.jdbcTemplate.update("INSERT INTO users (email) VALUES (?)", entity.getEmail());
    }

    @Override
    public void update(User entity) {
        this.jdbcTemplate.update("UPDATE users SET email=? WHERE id=?", entity.getEmail(), entity.getIdentifier());
    }

    @Override
    public void delete(Long id) {
        this.jdbcTemplate.update("DELETE FROM users WHERE id=?", id);
    }

    @Override
    public Optional<User> findByEmail(String email) {

        return Optional.ofNullable(this.jdbcTemplate.query("SELECT * FROM users WHERE email=?", new Object[]{email}, (rs, rowNum) -> new User(rs.getLong(1), rs.getString(2))).get(0));
    }
}

class JdbcDriver {

    DriverManagerDataSource dMdS;

    public JdbcDriver() throws IOException {

        this.dMdS = new DriverManagerDataSource();

        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        this.dMdS.setUrl(properties.getProperty("db.url"));
        this.dMdS.setUsername(properties.getProperty("db.user"));
        this.dMdS.setPassword(properties.getProperty("db.password"));
        this.dMdS.setDriverClassName(properties.getProperty("db.driver.name"));
    }

    public DriverManagerDataSource getDMDS()
    {
        return this.dMdS;
    }

}
