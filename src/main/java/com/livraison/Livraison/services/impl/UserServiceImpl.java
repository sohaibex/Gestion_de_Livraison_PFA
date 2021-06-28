package com.livraison.Livraison.services.impl;

import com.livraison.Livraison.entities.UserEntity;
import com.livraison.Livraison.models.User;
import com.livraison.Livraison.repository.UserRepo;
import com.livraison.Livraison.services.UserService;
import com.livraison.Livraison.sheared.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    Utils util;

//injection de dependance
    @Autowired
   UserRepo userRepo;

    @Override
    //implementation de la methode create user
    public User createUser(User user) {

        //methode check user
      UserEntity checkUser=  userRepo.findUserByEmail(user.getEmail());
if(checkUser != null) throw new RuntimeException("User already exist ");
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user,userEntity);
        userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userEntity.setUserId(util.generateStringId(32));
//la persistance
      UserEntity newUser= userRepo.save(userEntity);

      User userDto= new User();
      BeanUtils.copyProperties(newUser,userDto);
        return userDto;

    }


    //la methode de la class UserDetailsService sert de recuperer l'utilisateur authentifier de la DB on utilisent le repo
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UserEntity userEntity = userRepo.findUserByEmail(email);
        //Verification
        if(userEntity == null) throw new UsernameNotFoundException(email);

        return new org.springframework.security.core.userdetails.User(userEntity.getEmail(), userEntity.getEncryptedPassword(), new ArrayList<>());
    }


    @Override
    public User getUser(String email) {
        UserEntity userEntity = userRepo.findUserByEmail(email);

        //verification
        if(userEntity==null)
        {
            throw  new UsernameNotFoundException(email);
        }
        else
        {
             User user = new User();
             BeanUtils.copyProperties(userEntity,user);
            return user;
        }
    }

    @Override
    public User getUserById(String userId) {
        UserEntity userEntity = userRepo.findUserByUserId(userId);
        if(userEntity==null)
        {
            throw  new UsernameNotFoundException(userId);
        }
        else
        {
            User userDto = new User();
            BeanUtils.copyProperties(userEntity,userDto);
            return userDto;
        }
    }

    @Override
    public User updateUser(String userId, User userDto) {

        UserEntity userEntity = userRepo.findUserByUserId(userId);

        if(userEntity == null) throw new UsernameNotFoundException(userId);

        userEntity.setNom(userDto.getNom());
        userEntity.setPrenom(userDto.getPrenom());

        UserEntity userUpdated = userRepo.save(userEntity);

        User user = new User();

        BeanUtils.copyProperties(userUpdated, user);

        return user;
    }


    @Override
    public void deleteUser(String userId) {

    }

    @Override
    public List<User> getUsers(int page, int limit, String search, int status) {
        return null;
    }


}
