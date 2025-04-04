package com.demoSpring.demoSpring.config;

import com.demoSpring.demoSpring.entidades.User;
import com.demoSpring.demoSpring.repositorios.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test") // MESMO NOME INSERIDO NO application.properties em spring.profiles.active=test
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepositories userRepositories;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
        userRepositories.saveAll(Arrays.asList(u1,u2));
    }
}
