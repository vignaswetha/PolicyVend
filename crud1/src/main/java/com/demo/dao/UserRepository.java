package com.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.stereotype.Repository;

import com.demo.entity.User;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}


