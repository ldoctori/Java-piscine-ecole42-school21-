package school21.spring.sockets.services;

import school21.spring.sockets.models.User;
import school21.spring.sockets.repositories.UsersRepository;

public interface UsersService {


    void setUsersRepository(UsersRepository usersRepository);
    public String signUp(User user);

}
