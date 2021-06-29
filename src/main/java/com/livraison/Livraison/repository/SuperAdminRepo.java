package com.livraison.Livraison.repository;

import com.livraison.Livraison.entities.SuperAdminEntity;
import org.springframework.data.repository.CrudRepository;

public interface SuperAdminRepo extends CrudRepository<SuperAdminEntity, Long> {

        SuperAdminEntity findSuperAdminEntitiesByEmail(String email);
        SuperAdminEntity findSuperAdminEntityById(String id);

        }
