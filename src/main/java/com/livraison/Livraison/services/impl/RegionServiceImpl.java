package com.livraison.Livraison.services.impl;

import com.livraison.Livraison.entities.RegionEntity;
import com.livraison.Livraison.entities.SuperAdminEntity;
import com.livraison.Livraison.repository.RegionRepo;
import com.livraison.Livraison.services.RegionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegionServiceImpl implements RegionService {

    @Autowired
    RegionRepo regionRepo;

    @Override
    public RegionEntity getRegionById(String  regionId) {
        RegionEntity regionEntity = regionRepo.findRegionEntityByRegionId(regionId);
        if (regionEntity == null) {
            throw new UsernameNotFoundException(regionId);
        } else {
            RegionEntity regionDto = new RegionEntity();
            BeanUtils.copyProperties(regionEntity, regionDto);
            return regionDto;
        }
    }

    @Override
    public List<RegionEntity> getAllRergions(int page, int limit) {
        List<RegionEntity> regionDto = new ArrayList<>();
        Pageable pageableRequest = PageRequest.of(page, limit);
        Page<RegionEntity> regionPage = regionRepo.findAll(pageableRequest);
        List<RegionEntity> regions = regionPage.getContent();
        for (RegionEntity regionEntity : regions)
        {
            RegionEntity user = new RegionEntity();
            BeanUtils.copyProperties(regionEntity, user);
            regionDto.add(user);
        }
        return regionDto;
    }
}
