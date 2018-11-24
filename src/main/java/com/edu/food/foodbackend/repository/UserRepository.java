package com.edu.food.foodbackend.repository;

import com.edu.food.foodbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByAccount(String account);
}
