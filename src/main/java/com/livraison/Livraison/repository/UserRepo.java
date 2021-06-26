package com.livraison.Livraison.repository;

import com.livraison.Livraison.entities.UserEntity;
import com.livraison.Livraison.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



//heritage de la classe crud repository  qui contient tous les methode naisaissaire du crud
@Repository
public interface UserRepo  extends CrudRepository<UserEntity, Long> {

    User findUserByUsername(String username);

    User findUserByEmail(String email);
}
