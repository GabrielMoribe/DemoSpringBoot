package com.demoSpring.demoSpring.resources;

import com.demoSpring.demoSpring.entidades.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserResources {

    @GetMapping
    public ResponseEntity<User> findAll(){
        User u = new User(1L,"Anna","Annam@email.com","9999-9999","1234");
        System.out.println("---Método findAll chamado!---");
        return ResponseEntity.ok().body(u);
    }
}
