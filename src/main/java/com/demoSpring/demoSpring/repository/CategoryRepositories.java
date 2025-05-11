package com.demoSpring.demoSpring.repository;

import com.demoSpring.demoSpring.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepositories extends JpaRepository<Category,Long> {
}
