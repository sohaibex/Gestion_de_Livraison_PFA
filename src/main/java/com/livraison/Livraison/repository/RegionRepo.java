package com.livraison.Livraison.repository;

import com.livraison.Livraison.entities.RegionEntity;
import com.livraison.Livraison.entities.SuperAdminEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface RegionRepo   extends PagingAndSortingRepository<RegionEntity, Long> {
    RegionEntity findRegionEntityByRegionId(String regionId);
    List<RegionEntity> findAll();
}
