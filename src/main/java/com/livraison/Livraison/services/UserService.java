package com.livraison.Livraison.services;

import com.livraison.Livraison.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService  {

    User createUser(User user);

    User getUser(String email);

    User getUserByUserId(String userId);

    User updateUser(String id, User User);

    void deleteUser(String userId);

    List<User> getUsers(int page, int limit, String search, int status);

}