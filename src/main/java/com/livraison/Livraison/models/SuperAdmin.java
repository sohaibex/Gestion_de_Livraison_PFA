package com.livraison.Livraison.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@DiscriminatorValue("Super_Admin")
public class SuperAdmin extends User implements Serializable  {

}
