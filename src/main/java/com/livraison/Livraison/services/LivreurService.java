package com.livraison.Livraison.services;

import com.livraison.Livraison.entities.LivreurEntity;
import com.livraison.Livraison.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface LivreurService extends UserDetailsService {


    LivreurEntity createLivreur(LivreurEntity livreur);

    LivreurEntity getLivreur(String email);

    LivreurEntity getLivreurById(String superAdminId);

    LivreurEntity updateLivreur(String livreurId, LivreurEntity livreurDto);

    void deleteLivreur(String livreurId);

    List<User> getLivreur(int page, int limit, String search, int status);

}
