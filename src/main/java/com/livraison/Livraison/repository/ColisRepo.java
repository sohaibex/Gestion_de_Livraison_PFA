package com.livraison.Livraison.repository;

import com.livraison.Livraison.entities.ColisEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ColisRepo extends PagingAndSortingRepository<ColisEntity, Long> {

    ColisEntity findColisEntityById(String codeColis);
    ColisEntity findColisById(Long id);
}
