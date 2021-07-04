package com.livraison.Livraison.services;

import com.livraison.Livraison.entities.AgenceEntity;
import com.livraison.Livraison.models.Agence;

import java.util.List;

public interface AgencesService {

    AgenceEntity createAgence(AgenceEntity agence);

    AgenceEntity getAgenceById(String agenceId);

    AgenceEntity getAgence(String agenceId);

    AgenceEntity updateAgence(String agenceId, AgenceEntity agenceDto);

    void deleteAgence(String agenceId);

    List<Agence> getAgence(int page, int limit);

}
