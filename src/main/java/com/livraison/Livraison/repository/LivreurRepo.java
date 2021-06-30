package com.livraison.Livraison.repository;

import com.livraison.Livraison.entities.LivreurEntity;
import com.livraison.Livraison.entities.SuperAdminEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface LivreurRepo extends PagingAndSortingRepository<LivreurEntity, Long> {

    LivreurEntity findLivreurByEmail(String email);
    LivreurEntity findUserByUserId(String superAdminId);

}
