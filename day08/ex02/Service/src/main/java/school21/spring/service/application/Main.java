package school21.spring.service.application;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import school21.spring.service.config.ApplicationConfig;
import school21.spring.service.models.User;
import school21.spring.service.repositories.UsersRepository;
import org.springframework.config.java.context.JavaConfigApplicationContext;
import school21.spring.service.config.ApplicationConfig;
import school21.spring.service.services.UsersService;

import java.util.List;

public class Main {

    public static void main(String[] args) {


        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(school21.spring.service.config.ApplicationConfig.class);
        UsersRepository usersRepository = context.getBean("usersRepositoryJdbc", UsersRepository.class);
        //System.out.println(usersRepository.findAll());
        List<User> users = usersRepository.findAll();
        for (User u : users) {
            System.out.println(u.getEmail());
        }
        usersRepository = context.getBean("usersRepositoryJdbcTemplate", UsersRepository.class);
        System.out.println(usersRepository.findAll());

        UsersService us = context.getBean("usersServiceImpl", UsersService.class);
        System.out.println("Generated password!" + us.signUp("SOMENNNNEW@yandex.ru"));
    }
}
