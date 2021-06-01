package com.livraison.Livraison.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;
@Entity
@DiscriminatorValue("Super_Admin")
public class SuperAdmin extends User {

}
