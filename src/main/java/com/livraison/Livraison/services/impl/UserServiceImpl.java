package com.livraison.Livraison.services.impl;

import com.livraison.Livraison.entities.UserEntity;
import com.livraison.Livraison.models.User;
import com.livraison.Livraison.repository.UserRepo;
import com.livraison.Livraison.services.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
//injection de dependance
    @Autowired
   UserRepo userRepo;
    @Override
    //implementation de la methode create user
    public User createUser(User user) {

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user,userEntity);
//la persistance
      UserEntity newUser= userRepo.save(userEntity);
      User userDto= new User();
      BeanUtils.copyProperties(newUser,userDto);
        return userDto;

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
