package com.livraison.Livraison.services.impl;

import com.livraison.Livraison.models.User;
import com.livraison.Livraison.services.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public User getUser(String email) {
        return null;
    }

    @Override
    public User getUserByUserId(String userId) {
        return null;
    }

    @Override
    public User updateUser(String id, User User) {
        return null;
    }

    @Override
    public void deleteUser(String userId) {

    }

    @Override
    public List<User> getUsers(int page, int limit, String search, int status) {
        return null;
    }


}
