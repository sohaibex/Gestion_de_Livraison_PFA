package com.livraison.Livraison.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Responsable_Agence")
public class ResponsableAgence extends User  {
}
