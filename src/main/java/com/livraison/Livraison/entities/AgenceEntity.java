package com.livraison.Livraison.entities;

import javax.persistence.*;
import java.util.Set;

@Entity(name="agences")
public class AgenceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "nom_Agence", length = 225)
    private String nomAgence;

    @ManyToOne
    @JoinColumn(name="id_ville", nullable=false)
    private VilleEntity ville;

    @ManyToMany
    Set<ColisEntity> colis;



    public AgenceEntity(Long id, String nomAgence, VilleEntity ville) {
        this.id = id;
        this.nomAgence = nomAgence;
        this.ville = ville;
    }

    public AgenceEntity() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomAgence() {
        return nomAgence;
    }

    public void setNomAgence(String nomAgence) {
        this.nomAgence = nomAgence;
    }

}
