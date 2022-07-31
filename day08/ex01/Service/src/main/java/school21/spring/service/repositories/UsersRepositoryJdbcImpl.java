package school21.spring.service.repositories;

import school21.spring.service.models.User;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.zaxxer.hikari.HikariDataSource;

public class UsersRepositoryJdbcImpl implements UsersRepository {


    private final Connection connection;

    public UsersRepositoryJdbcImpl(HikariDataSource hikariDataSource) throws SQLException {

        this.connection = hikariDataSource.getConnection();
    }

    @Override
    public List<User> findAll() {

        PreparedStatement preState;
        ResultSet resultSet;
        List<User> productsList = new ArrayList<>();
        try {
            preState = connection.prepareStatement("SELECT * FROM users");
            resultSet = preState.executeQuery();
            while (resultSet.next()) {
                productsList.add(new User(resultSet.getLong("id"),
                        resultSet.getString("email")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productsList;
    }

    @Override
    public Optional<User> findById(Long id) {

        PreparedStatement preState;
        ResultSet resultSet;
        User user = null;
        try {
            preState = connection.prepareStatement("SELECT * FROM user WHERE id = " + id.toString());
            resultSet = preState.executeQuery();
            if (resultSet.next()) {
                user = new User(resultSet.getLong("id"),
                        resultSet.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(user);
    }

    @Override
    public void delete(Long id) {

        PreparedStatement preState;

        try {
            preState = connection.prepareStatement("DELETE FROM user WHERE id = ?");
            preState.setLong(1, id);
            preState.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(User user) {

        PreparedStatement preState;

        try {
            preState = connection.prepareStatement("INSERT INTO users (email) VALUES (?)");
            preState.setString(1, user.getEmail());
            preState.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User user) {

        PreparedStatement preState;

        try {
            if (findById(user.getIdentifier()).isPresent()) {
                preState = connection.prepareStatement("UPDATE users SET "
                        + "email=?"
                        + "WHERE id=?");
                preState.setString(1, user.getEmail());
                preState.setLong(3, user.getIdentifier());
                preState.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<User> findByEmail(String email) {

        PreparedStatement preState;
        ResultSet resultSet;
        User user = null;
        try {
            preState = connection.prepareStatement("SELECT * FROM user WHERE email = " + email);
            resultSet = preState.executeQuery();
            if (resultSet.next()) {
                user = new User(resultSet.getLong("id"),
                        resultSet.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(user);
    }
}

class Hikari {

    HikariDataSource hikariDataSource;

    public Hikari() throws IOException {

        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        this.hikariDataSource = new HikariDataSource();
        this.hikariDataSource.setJdbcUrl(properties.getProperty("db.url"));
        this.hikariDataSource.setUsername(properties.getProperty("db.user"));
        this.hikariDataSource.setPassword(properties.getProperty("db.password"));
        this.hikariDataSource.setDriverClassName(properties.getProperty("db.driver.name"));
    }

    public HikariDataSource getHDS() {
        return this.hikariDataSource;
    }

}
