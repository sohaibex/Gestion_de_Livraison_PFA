package com.livraison.Livraison.services;


import com.livraison.Livraison.entities.VendeurEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface VendeurService extends UserDetailsService {

    VendeurEntity createVendeur(VendeurEntity vendeur);

    VendeurEntity getVendeur(String email);

    VendeurEntity getVendeurById(String vendeurId);

    VendeurEntity updateVendeur(String vendeurId, VendeurEntity vendeurDto);

    void deleteVendeur(String vendeurId);
    List<VendeurEntity> getAllVendeurs(int page, int limit);



}
