package school21.spring.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import school21.spring.service.repositories.UsersRepository;

import javax.jws.soap.SOAPBinding;

public interface UsersService {


    void setUsersRepository(UsersRepository usersRepository);
    public String signUp(String email);

}
