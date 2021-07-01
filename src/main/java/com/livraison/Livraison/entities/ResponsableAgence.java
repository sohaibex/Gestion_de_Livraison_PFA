package com.livraison.Livraison.entities;




import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@DiscriminatorValue("Responsable_Agence")
public class ResponsableAgence extends UserEntity implements Serializable {
}