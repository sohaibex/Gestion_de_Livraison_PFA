package com.livraison.Livraison.repository;

import com.livraison.Livraison.entities.RegionEntity;
import com.livraison.Livraison.entities.VilleEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface VilleRepo  extends PagingAndSortingRepository<VilleEntity, Long> {

    List<VilleEntity> findAll();
}
