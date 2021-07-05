package com.livraison.Livraison.services;

import com.livraison.Livraison.entities.SuperAdminEntity;
import com.livraison.Livraison.entities.VilleEntity;

import java.util.List;

public interface VilleService {


    List<VilleEntity> getAllVilles(int page, int limit);
}
