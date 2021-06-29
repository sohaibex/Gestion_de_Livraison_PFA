package com.livraison.Livraison.repository;

import com.livraison.Livraison.entities.LivreurEntity;
import com.livraison.Livraison.entities.SuperAdminEntity;
import org.springframework.data.repository.CrudRepository;

public interface LivreurRepo extends CrudRepository<LivreurEntity, Long> {

    LivreurEntity findLivreurByEmail(String email);
    LivreurEntity findUserByUserId(String superAdminId);

}
