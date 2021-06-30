package com.livraison.Livraison.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity(name="vendeurs")
@DiscriminatorValue("Vendeur")
public class VendeurEntity extends UserEntity {

    @OneToMany
    private List<ColisEntity> colis = new ArrayList<>();
}
