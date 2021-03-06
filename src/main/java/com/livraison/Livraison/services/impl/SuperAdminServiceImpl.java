package com.livraison.Livraison.services.impl;

import com.livraison.Livraison.entities.SuperAdminEntity;

import com.livraison.Livraison.repository.SuperAdminRepo;
import com.livraison.Livraison.services.SuperAdminService;
import com.livraison.Livraison.sheared.Utils;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class SuperAdminServiceImpl implements SuperAdminService {
    @Autowired
    SuperAdminRepo superAdminRepo;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    Utils util;

    @Override
    public SuperAdminEntity createSuperAdmin(SuperAdminEntity superAdmin) {
        SuperAdminEntity checkSuperAdmin = superAdminRepo.findSuperAdminByEmail(superAdmin.getEmail());
        if (checkSuperAdmin != null) throw new RuntimeException("User already exist ");
        SuperAdminEntity superAdminEntity = new SuperAdminEntity();
        BeanUtils.copyProperties(superAdmin, superAdminEntity);
        superAdminEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(superAdmin.getPassword()));
        superAdminEntity.setUserId(util.generateStringId(32));
        SuperAdminEntity newSuperAdmin = superAdminRepo.save(superAdminEntity);
        SuperAdminEntity superAdminDto = new SuperAdminEntity();
        BeanUtils.copyProperties(newSuperAdmin, superAdminDto);
        return superAdminDto;
    }

    @Override
    public SuperAdminEntity getSuperAdmin(String email) {
        SuperAdminEntity superAdminEntity = superAdminRepo.findSuperAdminByEmail(email);

        //verification
        if (superAdminEntity == null) {
            throw new UsernameNotFoundException(email);
        } else {
            SuperAdminEntity superAdminDto = new SuperAdminEntity();
            BeanUtils.copyProperties(superAdminEntity, superAdminDto);
            return superAdminDto;
        }
    }

    @Override
    public SuperAdminEntity getSuperAdminById(String superAdminId) {
        SuperAdminEntity superAdminEntity = superAdminRepo.findSuperAdminByEmail(superAdminId);
        if (superAdminEntity == null) {
            throw new UsernameNotFoundException(superAdminId);
        } else {
            SuperAdminEntity superAdminDto = new SuperAdminEntity();
            BeanUtils.copyProperties(superAdminEntity, superAdminDto);
            return superAdminDto;
        }
    }

    @Override
    public SuperAdminEntity updateSuperAdmin(String superAdminId, SuperAdminEntity superAdmin) {
        SuperAdminEntity superAdminEntity = superAdminRepo.findUserByUserId(superAdminId);

        if (superAdminEntity == null) throw new UsernameNotFoundException(superAdminId);

        superAdminEntity.setNom(superAdmin.getNom());
        superAdminEntity.setPrenom(superAdmin.getPrenom());

        SuperAdminEntity superAdminUpdated = superAdminRepo.save(superAdminEntity);

        SuperAdminEntity superAdminDto = new SuperAdminEntity();

        BeanUtils.copyProperties(superAdminUpdated, superAdminDto);

        return superAdminDto;
    }

    @Override
    public void deleteSuperAdmin(String superAdminId) {
        SuperAdminEntity superAdminEntity = superAdminRepo.findUserByUserId(superAdminId);

        if (superAdminEntity == null) throw new UsernameNotFoundException(superAdminId);

        superAdminRepo.delete(superAdminEntity);
    }


    @Override
    public List<SuperAdminEntity> getAllSuperAdmins(int page, int limit) {
        List<SuperAdminEntity> superAdminsDto = new ArrayList<>();
        Pageable pageableRequest = PageRequest.of(page, limit);
        Page<SuperAdminEntity> superAdminPage = superAdminRepo.findAll(pageableRequest);
        List<SuperAdminEntity> superAdmins = superAdminPage.getContent();
        for (SuperAdminEntity superAdminEntity : superAdmins) {
            SuperAdminEntity user = new SuperAdminEntity();
            BeanUtils.copyProperties(superAdminEntity, user);
            superAdminsDto.add(user);
        }
        return superAdminsDto;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        SuperAdminEntity superAdminEntity = superAdminRepo.findSuperAdminByEmail(email);
        //Verification
        if (superAdminEntity == null) throw new UsernameNotFoundException(email);

        return new org.springframework.security.core.userdetails.User(superAdminEntity.getEmail(), superAdminEntity.getEncryptedPassword(), new ArrayList<>());
    }

}
