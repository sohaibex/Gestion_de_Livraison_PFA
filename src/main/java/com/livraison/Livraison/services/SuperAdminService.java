package com.livraison.Livraison.services;

import com.livraison.Livraison.models.SuperAdmin;
import com.livraison.Livraison.repository.SuperAdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
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
        return superadminRepo.save(superadmin);
    }

    public SuperAdmin updateSuperAdmin(SuperAdmin superadmin)
    {
        return superadminRepo.save(superadmin);
    }

    public List<SuperAdmin> getAllSuperAdmin()
    {
        return superadminRepo.findAll();
    }

    public SuperAdmin getSuperAdminById(long id)
    {
        return superadminRepo.getSuperAdminById(id).orElseThrow(() -> new UserNotFoundException("User by id"+id+"was not found"));
    }

    public void deleteSuperAdmin(Long id)
    {
        superadminRepo.deleteSuperAdminById(id);
    }



}
