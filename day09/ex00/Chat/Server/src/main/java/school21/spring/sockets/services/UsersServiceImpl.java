package school21.spring.sockets.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import school21.spring.sockets.models.User;
import school21.spring.sockets.repositories.UsersRepository;
import school21.spring.sockets.repositories.UsersRepositoryJdbc;

@Component
public class UsersServiceImpl implements UsersService {

    UsersRepository usersRepository;
    @Override
    @Autowired
    @Qualifier("usersRepositoryJdbcTemplate")
    public void setUsersRepository(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }


    public String signUp(User user) {

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String cryptoPassword = bCryptPasswordEncoder.encode(user.getPassword());

        try {
            JdbcTemplate jdbcTemplate = ((UsersRepositoryJdbc) usersRepository).getJdbcTemplate();
            jdbcTemplate.update("INSERT INTO users (name, password) VALUES ('" + user.getName() + "', '" + cryptoPassword + "')", new Object[]{});
        } catch (DataAccessException e) {
            return "Something goes wrong!";
        }
        return "Successful!";
    }
}
