package com.demoSpring.demoSpring.repositorios;

import com.demoSpring.demoSpring.entidades.User;
import org.springframework.data.jpa.repository.JpaRepository;

// NAO PRECISA DE @REPOSITORY POIS JA HERDA DE UM REPOSITORIO REGISTRADO
public interface UserRepositories  extends JpaRepository<User,Long> {
}
