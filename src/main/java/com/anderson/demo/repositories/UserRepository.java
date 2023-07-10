package com.anderson.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anderson.demo.models.User;

// @Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
}
