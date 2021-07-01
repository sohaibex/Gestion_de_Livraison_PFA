package com.livraison.Livraison.services.impl;

import com.livraison.Livraison.entities.ResponsableAgence;
import com.livraison.Livraison.repository.ResponsableAgentRepo;
import com.livraison.Livraison.sheared.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ResponsableAgentService {

    private ResponsableAgentRepo responsableAgentRepo;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    Utils util;

    @Autowired
    public ResponsableAgentService(ResponsableAgentRepo responsableAgentRepo) {
        this.responsableAgentRepo = responsableAgentRepo;
    }

    public ResponsableAgence addResponsableAgence(ResponsableAgence responsableAgence) {
        responsableAgence.setUserId(UUID.randomUUID().toString());
        responsableAgence.setEncryptedPassword(bCryptPasswordEncoder.encode(responsableAgence.getPassword()));
        return responsableAgentRepo.save(responsableAgence);
    }

    public ResponsableAgence updateResponsableAgence(ResponsableAgence responsableAgence) {
        return responsableAgentRepo.save(responsableAgence);
    }

    public List<ResponsableAgence> gettAllResponsableAgent(int page, int limit) {
        List<ResponsableAgence> responsableAgencesDto = new ArrayList<>();
        Pageable pageableRequest = PageRequest.of(page, limit);
        Page<ResponsableAgence> responsableAgencePage = responsableAgentRepo.findAll(pageableRequest);
        List<ResponsableAgence> responsableAgences = responsableAgencePage.getContent();
        for (ResponsableAgence responsableAgenceEntity : responsableAgences) {
            ResponsableAgence user = new ResponsableAgence();
            BeanUtils.copyProperties(responsableAgenceEntity, user);
            responsableAgencesDto.add(user);
        }
        return responsableAgencesDto;
    }

    public ResponsableAgence getResponsablAgentById(long id) {
        return responsableAgentRepo.getResponsableAgenceById(id).orElseThrow(() -> new UsernameNotFoundException("User " + id + " was nt found"));
    }

    public void deleteResponsableAgent(long id) {
        responsableAgentRepo.deleteResponsableAgenceById(id);
    }
}
