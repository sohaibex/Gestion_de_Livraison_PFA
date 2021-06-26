package com.livraison.Livraison.models;

import com.livraison.Livraison.entities.UserEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@DiscriminatorValue("Super_Admin")
public class SuperAdmin extends UserEntity implements Serializable  {

}
