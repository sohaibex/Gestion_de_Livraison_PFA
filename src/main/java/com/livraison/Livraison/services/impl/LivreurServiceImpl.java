package com.livraison.Livraison.services.impl;

import com.livraison.Livraison.entities.LivreurEntity;
import com.livraison.Livraison.entities.SuperAdminEntity;
import com.livraison.Livraison.entities.UserEntity;
import com.livraison.Livraison.models.User;
import com.livraison.Livraison.repository.LivreurRepo;
import com.livraison.Livraison.repository.UserRepo;
import com.livraison.Livraison.services.LivreurService;
import com.livraison.Livraison.sheared.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LivreurServiceImpl implements LivreurService {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    Utils util;

    //injection de dependance
    @Autowired
    LivreurRepo livreurRepo;


    @Override
    public LivreurEntity createLivreur(LivreurEntity livreur) {
        //methode check user
        LivreurEntity checkUser = livreurRepo.findLivreurByEmail(livreur.getEmail());
        if (checkUser != null) throw new RuntimeException("Livreur already exist ");
        LivreurEntity livreurDto = new LivreurEntity();
        BeanUtils.copyProperties(livreur, livreurDto);
        livreurDto.setEncryptedPassword(bCryptPasswordEncoder.encode(livreur.getPassword()));
        livreurDto.setUserId(util.generateStringId(32));
        //la persistance
        LivreurEntity newLivreur = livreurRepo.save(livreurDto);

        LivreurEntity livreurEntity = new LivreurEntity();
        BeanUtils.copyProperties(newLivreur, livreurEntity);
        return livreurEntity;
    }


    @Override
    public LivreurEntity getLivreur(String email) {
        LivreurEntity livreurEntity = livreurRepo.findLivreurByEmail(email);

        //verification
        if(livreurEntity==null)
        {
            throw  new UsernameNotFoundException(email);
        }
        else
        {
            LivreurEntity livreurDto = new LivreurEntity();
            BeanUtils.copyProperties(livreurEntity,livreurDto);
            return livreurDto;
        }
    }

    @Override
    public LivreurEntity getLivreurById(String livreurId) {
        LivreurEntity livreurEntity = livreurRepo.findUserByUserId(livreurId);

        //verification
        if(livreurEntity==null)
        {
            throw  new UsernameNotFoundException(livreurId);
        }
        else
        {
            LivreurEntity livreurDto = new LivreurEntity();
            BeanUtils.copyProperties(livreurEntity,livreurDto);
            return livreurDto;
        }
    }

    @Override
    public LivreurEntity updateLivreur(String livreurId, LivreurEntity livreur) {
        LivreurEntity livreurEntity = livreurRepo.findUserByUserId(livreurId);

        if(livreurEntity == null) throw new UsernameNotFoundException(livreurId);

        livreurEntity.setNom(livreur.getNom());
        livreurEntity.setPrenom(livreur.getPrenom());
        livreurEntity.setCin(livreur.getCin());
        livreurEntity.setTel(livreur.getTel());
        livreurEntity.setAdresse(livreur.getAdresse());
        livreurEntity.setEmail(livreur.getEmail());

        LivreurEntity livreurUpdated = livreurRepo.save(livreurEntity);

        LivreurEntity livreurDto = new LivreurEntity();

        BeanUtils.copyProperties(livreurUpdated, livreurDto);

        return livreurDto;
    }

    @Override
    public void deleteLivreur(String livreurId) {
        LivreurEntity livreurEntity = livreurRepo.findUserByUserId(livreurId);

        if(livreurEntity == null) throw new UsernameNotFoundException(livreurId);

        livreurRepo.delete(livreurEntity);
    }

    @Override
    public List<User> getLivreur(int page, int limit, String search, int status) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
