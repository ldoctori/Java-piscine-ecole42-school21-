package school21.spring.service.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UsersServiceImplTest {

    @Test
    public void signUpTest() {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(school21.spring.service.config.ApplicationConfig.class);
        UsersService us = context.getBean("usersServiceImpl", UsersService.class);
        Assertions.assertNotNull(us.signUp("anyNewUser@yandex.ru"));
    }

}
