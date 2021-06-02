package com.livraison.Livraison.repository;

import com.livraison.Livraison.models.SuperAdmin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SuperAdminRepo extends JpaRepository<SuperAdmin,Long> {
    void deleteSuperAdminById(Long id);

    Optional<SuperAdmin> getSuperAdminById(Long id);
}
