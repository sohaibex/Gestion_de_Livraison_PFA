package com.livraison.Livraison.entities;

import com.livraison.Livraison.entities.UserEntity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@DiscriminatorValue("Livreur")
public class Livreur extends UserEntity implements Serializable {


}
