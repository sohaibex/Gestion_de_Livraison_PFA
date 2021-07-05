package com.livraison.Livraison.repository;

import com.livraison.Livraison.entities.AgenceEntity;
import com.livraison.Livraison.entities.LivreurEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AgencesRepo extends PagingAndSortingRepository<AgenceEntity, Long> {



    AgenceEntity findAgenceEntitiesByAgenceId(String agenceId);

}
