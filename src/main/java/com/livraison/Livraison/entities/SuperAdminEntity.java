package com.livraison.Livraison.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity(name="superadmin")
@DiscriminatorValue("Super_Admin")
public class SuperAdminEntity extends UserEntity implements Serializable {


}
