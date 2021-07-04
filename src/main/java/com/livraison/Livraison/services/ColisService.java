package com.livraison.Livraison.services;

import com.livraison.Livraison.entities.ColisEntity;

import java.util.List;

public interface ColisService {

    ColisEntity createColis(ColisEntity colis);

    ColisEntity getColis(String codeColis);

    ColisEntity getColisById(Long id);

    ColisEntity updateColis(String codeColis, ColisEntity colisDto);

    void deleteColis(String codeColis);

    List<ColisEntity> getColis(String search, int status);
}
