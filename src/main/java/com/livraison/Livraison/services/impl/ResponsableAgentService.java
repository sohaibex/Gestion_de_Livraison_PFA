package com.livraison.Livraison.services.impl;

import com.livraison.Livraison.entities.ResponsableAgence;
import com.livraison.Livraison.repository.ResponsableAgentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ResponsableAgentService {

    private ResponsableAgentRepo responsableAgentRepo;

    @Autowired
    public ResponsableAgentService(ResponsableAgentRepo responsableAgentRepo){
        this.responsableAgentRepo = responsableAgentRepo;
    }

    public ResponsableAgence addResponsableAgence(ResponsableAgence responsableAgence)
    {
        responsableAgence.setUserId(UUID.randomUUID().toString());
        return responsableAgentRepo.save(responsableAgence);
    }

    public ResponsableAgence updateResponsableAgence(ResponsableAgence responsableAgence)
    {
        return responsableAgentRepo.save(responsableAgence);
    }

    public List<ResponsableAgence> gettAllResponsableAgent()
    {
        return responsableAgentRepo.findAll();
    }

    public ResponsableAgence getResponsablAgentById(long id)
    {
        return responsableAgentRepo.getResponsableAgenceById(id).orElseThrow(()-> new UsernameNotFoundException("User "+id+" was nt found"));
    }

    public void deleteResponsableAgent(long id)
    {
        responsableAgentRepo.deleteResponsableAgenceById(id);
    }
}
