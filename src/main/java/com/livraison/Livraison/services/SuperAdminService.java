package com.livraison.Livraison.services;

import com.livraison.Livraison.entities.SuperAdminEntity;
import com.livraison.Livraison.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface SuperAdminService  extends UserDetailsService {
    SuperAdminEntity createSuperAdmin(SuperAdminEntity superAdmin);

    SuperAdminEntity getSuperAdmin(String email);

    SuperAdminEntity getSuperAdminById(String superAdminId);

    SuperAdminEntity updateSuperAdmin(String superAdminId, SuperAdminEntity superAdminDto);

    void deletegetSuperAdmin(String userId);

    List<User> getSuperAdmin(int page, int limit, String search, int status);



}
