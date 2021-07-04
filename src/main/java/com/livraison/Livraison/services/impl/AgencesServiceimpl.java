package com.livraison.Livraison.services.impl;

import com.livraison.Livraison.controllers.AgencesController;
import com.livraison.Livraison.entities.AgenceEntity;
import com.livraison.Livraison.entities.LivreurEntity;
import com.livraison.Livraison.models.Agence;
import com.livraison.Livraison.repository.AgencesRepo;
import com.livraison.Livraison.services.AgencesService;
import com.livraison.Livraison.sheared.Utils;
import jdk.jshell.execution.Util;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgencesServiceimpl implements AgencesService {

    @Autowired
    Utils util;

    @Autowired
    AgencesRepo agenceRepo;



    @Override
    public AgenceEntity createAgence(AgenceEntity agence) {

        AgenceEntity checkAgence = agenceRepo.findAgenceEntitiesByAgenceId(agence.getAgenceId());
        if(checkAgence != null) throw new RuntimeException("Agence Alredy exist ");
        AgenceEntity agenceDto = new AgenceEntity();
        BeanUtils.copyProperties(agence, agenceDto);
        agenceDto.setAgenceId(util.generateStringId(32));

        AgenceEntity newAgence = agenceRepo.save(agenceDto);

        AgenceEntity agenceEntity = new AgenceEntity();
        BeanUtils.copyProperties(newAgence, agenceEntity);

        return agenceEntity;
    }

    @Override
    public AgenceEntity getAgenceById(String agenceId) {
        return null;
    }

    @Override
    public AgenceEntity updateAgence(String agenceId, AgenceEntity agenceDto) {
        return null;
    }

    @Override
    public void deleteAgence(String agenceId) {

    }

    @Override
    public List<Agence> getAgence(int page, int limit) {
        return null;
    }
}
