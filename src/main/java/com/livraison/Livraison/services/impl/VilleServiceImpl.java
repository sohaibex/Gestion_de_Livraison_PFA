package com.livraison.Livraison.services.impl;

import com.livraison.Livraison.entities.RegionEntity;
import com.livraison.Livraison.entities.VilleEntity;
import com.livraison.Livraison.repository.RegionRepo;
import com.livraison.Livraison.repository.VilleRepo;
import com.livraison.Livraison.services.VilleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class VilleServiceImpl implements VilleService {
    @Autowired
    VilleRepo villeRepo;



    @Override
    public List<VilleEntity> getAllVilles(int page, int limit) {
        List<VilleEntity> villeDto = new ArrayList<>();
        Pageable pageableRequest = PageRequest.of(page, limit);
        Page<VilleEntity> villePage = villeRepo.findAll(pageableRequest);
        List<VilleEntity> villes = villePage.getContent();
        for (VilleEntity villeEntity : villes) {
            VilleEntity user = new VilleEntity();
            BeanUtils.copyProperties(villeEntity, user);
            villeDto.add(user);
        }
        return villeDto;
    }
}
