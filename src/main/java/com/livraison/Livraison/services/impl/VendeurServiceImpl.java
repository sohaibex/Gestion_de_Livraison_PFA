package com.livraison.Livraison.services.impl;


import com.livraison.Livraison.entities.UserEntity;
import com.livraison.Livraison.entities.VendeurEntity;
import com.livraison.Livraison.repository.VendeurRepo;
import com.livraison.Livraison.services.VendeurService;
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
public class VendeurServiceImpl implements VendeurService {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    Utils util;

    //injection de dependance
    @Autowired
    VendeurRepo vendeurRepo;


    @Override
    public VendeurEntity createVendeur(VendeurEntity vendeur) {
        VendeurEntity checkVendeur = vendeurRepo.findVendeurEntityByEmail(vendeur.getEmail());
        if (checkVendeur != null) throw new RuntimeException("Vendeur already exist ");
        VendeurEntity vendeurEntity = new VendeurEntity();
        BeanUtils.copyProperties(vendeur, vendeurEntity);
        vendeurEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(vendeur.getPassword()));
        vendeurEntity.setUserId(util.generateStringId(32));
        VendeurEntity newVendeur = vendeurRepo.save(vendeurEntity);
        VendeurEntity vendeurDto = new VendeurEntity();
        BeanUtils.copyProperties(newVendeur, vendeurDto);
        return vendeurDto;
    }

    @Override
    public VendeurEntity getVendeur(String email) {
        VendeurEntity vendeurEntity = vendeurRepo.findVendeurEntityByEmail(email);

        //verification
        if (vendeurEntity == null) {
            throw new UsernameNotFoundException(email);
        } else {
            VendeurEntity vendeurDto = new VendeurEntity();
            BeanUtils.copyProperties(vendeurEntity, vendeurDto);
            return vendeurDto;
        }
    }

    @Override
    public VendeurEntity getVendeurById(String vendeurId) {
        VendeurEntity vendeurEntity = vendeurRepo.findVendeurEntityByEmail(vendeurId);
        if (vendeurEntity == null) {
            throw new UsernameNotFoundException(vendeurId);
        } else {
            VendeurEntity vendeurDto = new VendeurEntity();
            BeanUtils.copyProperties(vendeurEntity, vendeurDto);
            return vendeurDto;
        }
    }

    @Override
    public VendeurEntity updateVendeur(String vendeurId, VendeurEntity vendeur) {
        VendeurEntity vendeurEntity = vendeurRepo.findUserByUserId(vendeurId);

        if (vendeurEntity == null) throw new UsernameNotFoundException(vendeurId);

        vendeurEntity.setNom(vendeur.getNom());
        vendeurEntity.setPrenom(vendeur.getPrenom());
        vendeurEntity.setCin(vendeur.getCin());
        vendeurEntity.setTel(vendeur.getTel());
        vendeurEntity.setAdresse(vendeur.getAdresse());
        vendeurEntity.setEmail(vendeur.getEmail());

        VendeurEntity vendeurUpdated = vendeurRepo.save(vendeurEntity);

        VendeurEntity vendeurDto = new VendeurEntity();

        BeanUtils.copyProperties(vendeurUpdated, vendeurDto);

        return vendeurDto;
    }


    @Override
    public void deleteVendeur(String vendeurId) {


        VendeurEntity vendeurEntity = vendeurRepo.findUserByUserId(vendeurId);

        if (vendeurEntity == null) throw new UsernameNotFoundException(vendeurId);

        vendeurRepo.delete(vendeurEntity);

    }

    @Override
    public List<VendeurEntity> getAllVendeurs(int page, int limit) {
        List<VendeurEntity> vendeurDto = new ArrayList<>();
        Pageable pageableRequest = PageRequest.of(page, limit);
        Page<VendeurEntity> vendeurPage = vendeurRepo.findAll(pageableRequest);
        List<VendeurEntity> vendeurs = vendeurPage.getContent();
        for (VendeurEntity vendeurEntity : vendeurs) {
            VendeurEntity user = new VendeurEntity();
            BeanUtils.copyProperties(vendeurEntity, user);
            vendeurDto.add(user);
        }
        return vendeurDto;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = vendeurRepo.findVendeurEntityByEmail(email);
        //Verification
        if (userEntity == null) throw new UsernameNotFoundException(email);

        return new org.springframework.security.core.userdetails.User(userEntity.getEmail(), userEntity.getEncryptedPassword(), new ArrayList<>());
    }
}
