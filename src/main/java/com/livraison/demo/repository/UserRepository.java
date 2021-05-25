package com.livraison.demo.repository;

import com.livraison.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {


    User findByUserName(String username);
}
