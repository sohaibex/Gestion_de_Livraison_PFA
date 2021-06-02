package com.livraison.Livraison.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Vendeur")
public class Vendeur extends User {
}
