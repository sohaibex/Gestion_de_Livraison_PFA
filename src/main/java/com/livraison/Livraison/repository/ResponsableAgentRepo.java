package com.livraison.Livraison.repository;

import com.livraison.Livraison.entities.ResponsableAgence;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface ResponsableAgentRepo extends PagingAndSortingRepository<ResponsableAgence,Long> {
    void deleteResponsableAgenceById(Long id);
    Optional<ResponsableAgence> getResponsableAgenceById(Long id);
    List<ResponsableAgence> findAll();
}
