package com.demoSpring.demoSpring.config;

import com.demoSpring.demoSpring.model.*;
import com.demoSpring.demoSpring.Enum.OrderStatus;
import com.demoSpring.demoSpring.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration   // CLASSE DE CONFIGURACAO ???
@Profile("test") // MESMO NOME INSERIDO NO application.properties em spring.profiles.active=test
public class TestConfig implements CommandLineRunner {

    @Autowired // INJECAO DE DEPENDENCIA
    private UserRepositories userRepositories;
    @Autowired
    private OrderRepositories orderRepositories;
    @Autowired
    private CategoryRepositories categoryRepositories;
    @Autowired
    private ProductRepositories productRepositories;
    @Autowired
    private OrderItemRepositories orderItemRepositories;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
        userRepositories.saveAll(Arrays.asList(u1,u2));


        Order o1 = new Order(null, Instant.parse("2025-04-07T19:00:00Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2025-04-08T19:00:00Z"),OrderStatus.WAITING_PAYIMENT, u2);
        orderRepositories.saveAll(Arrays.asList(o1,o2));


        Category c1 = new Category(null, "Cereais");
        Category c2 = new Category(null, "Frutas");
        categoryRepositories.saveAll(Arrays.asList(c1,c2));


        Product p1 = new Product(null, "Banana","Amarela", 1.50, "img1");
        Product p2 = new Product(null, "Morango","Vermelho", 2.50, "img2");
        Product p3 = new Product(null, "aveia","Amarela", 1.50, "img3");
        productRepositories.saveAll(Arrays.asList(p1,p2,p3));

        p1.getCategory_list().add(c2);
        p2.getCategory_list().add(c2);
        p3.getCategory_list().add(c1);
        productRepositories.saveAll(Arrays.asList(p1,p2,p3));

        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice()*2);
        OrderItem oi2 = new OrderItem(o1, p2, 1, p2.getPrice());
        OrderItem oi3 = new OrderItem(o2, p3, 3, p3.getPrice()*3);
        orderItemRepositories.saveAll(Arrays.asList(oi1,oi2,oi3));

        Payment pay1 = new Payment(null , Instant.parse("2025-04-07T21:00:00Z") , o1);
        o1.setPayment(pay1);
        orderRepositories.save(o1);
    }
}
