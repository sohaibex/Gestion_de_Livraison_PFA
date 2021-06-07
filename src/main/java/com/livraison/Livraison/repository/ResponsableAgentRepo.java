package com.livraison.Livraison.repository;

import com.livraison.Livraison.models.ResponsableAgence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResponsableAgentRepo extends JpaRepository<ResponsableAgence,Long> {
    void deleteResponsableAgenceById(Long id);
    Optional<ResponsableAgence> getResponsableAgenceById(Long id);
}
