package com.livraison.Livraison.services.impl;

import com.livraison.Livraison.entities.ColisEntity;
import com.livraison.Livraison.entities.LivreurEntity;
import com.livraison.Livraison.repository.ColisRepo;
import com.livraison.Livraison.services.ColisService;
import com.livraison.Livraison.sheared.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ColisServiceImpl implements ColisService {

    @Autowired
    Utils util;

    @Autowired
    ColisRepo colisRepo;


    @Override
    public ColisEntity createColis(ColisEntity colis) {

        ColisEntity checkColis = colisRepo.findColisEntityById(colis.getCodeColis());
        if (checkColis != null) throw new RuntimeException("Code already exist ");
        ColisEntity colisDto = new ColisEntity();
        BeanUtils.copyProperties(colis, colisDto);

        colisDto.setCodeColis(util.generateStringId(32));
        //la persistance
        ColisEntity newColis = colisRepo.save(colisDto);

        ColisEntity colisEntity = new ColisEntity();
        BeanUtils.copyProperties(newColis, colisEntity);
        return colisEntity;

    }

    @Override
    public ColisEntity getColis(String codeColis) {
        ColisEntity colisEntity = colisRepo.findColisEntityById(codeColis);
        if(colisEntity==null)
        {
            throw new RuntimeException("Code dos not exist ");
        }
        else
        {
            ColisEntity colisDto = new ColisEntity();
            BeanUtils.copyProperties(colisEntity,colisDto);
            return colisDto;
        }
    }

    @Override
    public ColisEntity getColisById(Long id) {
        ColisEntity colisEntity = colisRepo.findColisById(id);
        if(colisEntity==null)
        {
            throw new RuntimeException("Code dos not exist ");
        }
        else
        {
            ColisEntity colisDto = new ColisEntity();
            BeanUtils.copyProperties(colisEntity,colisDto);
            return colisDto;
        }
    }

    @Override
    public ColisEntity updateColis(String codeColis, ColisEntity colis) {
        ColisEntity colisEntity = colisRepo.findColisEntityById(codeColis);

        if(colisEntity==null) throw new RuntimeException("Code dos not exist ");

        colisEntity.setCodeColis(colis.getCodeColis());
        colisEntity.setAdr(colis.getAdr());
        colisEntity.setAgenceArrive(colis.getAgenceArrive());
        colisEntity.setAgenceDepart(colis.getAgenceDepart());
        colisEntity.setLivreur(colis.getLivreur());
        colisEntity.setPoids(colis.getPoids());
        colisEntity.setFraisLivrison(colis.getFraisLivrison());
        colisEntity.setId_client(colis.getId_client());
        colisEntity.setStatue(colis.getStatue());
        colisEntity.setPrixU(colis.getPrixU());
        colisEntity.setPrixT(colis.getPrixT());
        colisEntity.setVendeur(colis.getVendeur());
        colisEntity.setVolume(colis.getVolume());
        colisEntity.setAgences(colis.getAgences());

        ColisEntity colisUpdated = colisRepo.save(colisEntity);
        ColisEntity colisDto = new ColisEntity();
        BeanUtils.copyProperties(colisUpdated, colisDto);
        return colisDto;
    }

    @Override
    public void deleteColis(String codeColis) {
        ColisEntity colisEntity = colisRepo.findColisEntityById(codeColis);

        if(colisEntity==null) throw new RuntimeException("Code dos not exist ");

        colisRepo.delete(colisEntity);
    }

    @Override
    public List<ColisEntity> getColis(String search, int status) {
        return null;
    }
}
