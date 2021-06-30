package com.livraison.Livraison.repository;

import com.livraison.Livraison.entities.UserEntity;
import com.livraison.Livraison.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;


//heritage de la classe crud repository  qui contient tous les methode naisaissaire du crud
@Repository
public interface UserRepo  extends PagingAndSortingRepository<UserEntity, Long> {
     UserEntity findUserByEmail(String email);
     UserEntity findUserByUserId(String userId);


}
