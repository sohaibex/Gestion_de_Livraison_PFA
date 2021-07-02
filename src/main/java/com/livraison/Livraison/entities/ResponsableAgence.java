package com.livraison.Livraison.entities;


import com.livraison.Livraison.entities.UserEntity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Entity
@DiscriminatorValue("Responsable_Agence")
public class ResponsableAgence extends UserEntity implements Serializable {

    @OneToOne
    @JoinColumn(name = "id_agence", nullable = false)
    private AgenceEntity id_agence;
}