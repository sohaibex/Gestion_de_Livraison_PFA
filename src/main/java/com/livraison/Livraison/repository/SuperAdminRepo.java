package com.livraison.Livraison.repository;

import com.livraison.Livraison.entities.SuperAdminEntity;
import com.livraison.Livraison.entities.UserEntity;
import com.livraison.Livraison.models.SuperAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SuperAdminRepo extends CrudRepository<SuperAdminEntity, Long> {

        SuperAdminEntity findSuperAdminEntitiesByEmail(String email);
        SuperAdminEntity findSuperAdminEntityById(String id);

        }
