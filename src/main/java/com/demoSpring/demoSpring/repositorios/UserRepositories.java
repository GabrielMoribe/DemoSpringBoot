package com.demoSpring.demoSpring.repositorios;

import com.demoSpring.demoSpring.entidades.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositories  extends JpaRepository<User,Long> {
}
