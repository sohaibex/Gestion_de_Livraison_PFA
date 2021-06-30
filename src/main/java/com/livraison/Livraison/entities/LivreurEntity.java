package com.livraison.Livraison.entities;

import com.livraison.Livraison.entities.UserEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@DiscriminatorValue("Livreurs")
public class LivreurEntity extends UserEntity implements Serializable {

    @OneToMany
    private List<ColisEntity> colis = new ArrayList<>();
}
