package com.livraison.Livraison.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@DiscriminatorValue("Responsable_Agence")
public class ResponsableAgence extends User implements Serializable {
}