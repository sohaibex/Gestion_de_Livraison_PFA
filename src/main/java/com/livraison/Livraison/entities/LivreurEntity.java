package com.livraison.Livraison.entities;

import com.livraison.Livraison.entities.UserEntity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@DiscriminatorValue("Livreurs")
public class LivreurEntity extends UserEntity implements Serializable {


}
