package com.livraison.Livraison.repository;

import com.livraison.Livraison.entities.SuperAdminEntity;
import org.springframework.data.repository.CrudRepository;

public interface SuperAdminRepo extends CrudRepository<SuperAdminEntity, Long> {

        SuperAdminEntity findSuperAdminByEmail(String email);
        SuperAdminEntity findUserByUserId(String superAdminId);

        }
