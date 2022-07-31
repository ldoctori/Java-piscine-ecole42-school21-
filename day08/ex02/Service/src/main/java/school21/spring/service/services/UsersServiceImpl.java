package school21.spring.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import school21.spring.service.models.User;
import school21.spring.service.repositories.UsersRepository;
import school21.spring.service.repositories.UsersRepositoryJdbcTemplate;
import java.util.Random;

@Component
public class UsersServiceImpl implements UsersService {

    UsersRepository usersRepository;
    @Override
    @Autowired
    @Qualifier("usersRepositoryJdbcTemplate")
    public void setUsersRepository(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }


    public String signUp(String email) {

        String arr = "QWERTYUIOP123456789ASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm";
        String generatedPassword = "";
        Random random = new Random();
        String name = email.split("@")[0];

        for (int i = 0; i < 5; i++) {
            generatedPassword += arr.toCharArray()[random.nextInt(arr.length())];
        }

        JdbcTemplate jdbcTemplate = ((UsersRepositoryJdbcTemplate) usersRepository).getJdbcTemplate();
        //jdbcTemplate.update("CREATE USER " + name + " WITH ENCRYPTED PASSWORD '" + generatedPassword + "'", new Object[]{});
        usersRepository.save(new User(Long.valueOf(1), email));
        return generatedPassword;
    }
}
