package com.livraison.Livraison.services;

import com.livraison.Livraison.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;



public interface UserService extends UserDetailsService {

    User createUser(User user);

    User getUser(String email);

    User getUserById(String userId);


}