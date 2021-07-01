package com.livraison.Livraison.repository;

import com.livraison.Livraison.entities.SuperAdminEntity;
import com.livraison.Livraison.entities.VendeurEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface VendeurRepo extends PagingAndSortingRepository<VendeurEntity, Long> {

    VendeurEntity findVendeurEntityByEmail(String email);
    VendeurEntity findUserByUserId(String vendeurId);
    List<VendeurEntity> findAll();


}
