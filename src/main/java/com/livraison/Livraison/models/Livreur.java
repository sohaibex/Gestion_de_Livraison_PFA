package com.livraison.Livraison.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@DiscriminatorValue("Livreur")
public class Livreur extends User implements Serializable {

}
