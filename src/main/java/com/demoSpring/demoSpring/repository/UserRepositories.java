package com.demoSpring.demoSpring.repository;

import com.demoSpring.demoSpring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositories  extends JpaRepository<User,Long> {
}
