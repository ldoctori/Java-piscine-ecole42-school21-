package school21.spring.service.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import school21.spring.service.models.User;
import java.util.List;
import java.util.Optional;

@Component
public class UsersRepositoryJdbcTemplate implements UsersRepository{

    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(DriverManagerDataSource driverManagerDataSource) {
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

    public JdbcTemplate getJdbcTemplate() {
        return this.jdbcTemplate;
    }
}
