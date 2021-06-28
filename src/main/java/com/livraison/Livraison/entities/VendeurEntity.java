package com.livraison.Livraison.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name="vendeur")
@DiscriminatorValue("Vendeur")
public class VendeurEntity extends UserEntity {
}
