package com.livraison.Livraison.repository;

import com.livraison.Livraison.entities.SuperAdminEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface SuperAdminRepo extends PagingAndSortingRepository<SuperAdminEntity, Long> {

        SuperAdminEntity findSuperAdminByEmail(String email);
        SuperAdminEntity findUserByUserId(String superAdminId);
        List<SuperAdminEntity> findAll();


        }
