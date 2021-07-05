package com.livraison.Livraison.services;

import com.livraison.Livraison.entities.RegionEntity;
import com.livraison.Livraison.entities.SuperAdminEntity;

import java.util.List;

public interface RegionService {

    RegionEntity getRegionById(String regionId );
    List<RegionEntity> getAllRergions(int page, int limit);
}
