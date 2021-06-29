package com.livraison.Livraison.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity(name="superadmins")
@DiscriminatorValue("Super_Admin")
public class SuperAdminEntity extends UserEntity implements Serializable {


}
