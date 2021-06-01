package com.livraison.Livraison.services;

import com.livraison.Livraison.models.SuperAdmin;
import com.livraison.Livraison.repository.SuperAdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SuperAdminService {

private final SuperAdminRepo superadminRepo;

    @Autowired
    public SuperAdminService(SuperAdminRepo superadminRepo) {
        this.superadminRepo = superadminRepo;
    }




    public SuperAdmin addSuperAdmin(SuperAdmin superadmin)
    {
        superadmin.setUserId(UUID.randomUUID().toString());
return SuperAdminRepo.save(superadmin);
    }



}
