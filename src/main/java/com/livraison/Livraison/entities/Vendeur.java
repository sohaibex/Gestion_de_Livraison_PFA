package com.livraison.Livraison.entities;

import com.livraison.Livraison.entities.UserEntity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Vendeur")
public class Vendeur extends UserEntity {
}
