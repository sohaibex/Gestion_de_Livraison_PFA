package com.livraison.Livraison.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity(name="villes")
public class VilleEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "nom_Ville", length = 225)
    private String nomVille;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable
    private Set<UserEntity> users;

    @ManyToOne
    @JoinColumn(name="id_region", nullable=false)
    private RegionEntity region;

    @OneToMany(mappedBy = "ville")
    private Set<AgenceEntity> agence;




    public VilleEntity() {}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomVille() {
        return nomVille;
    }

    public void setNomVille(String nomVille) {
        this.nomVille = nomVille;
    }

    public RegionEntity getRegion() {
        return region;
    }

    public void setRegion(RegionEntity region) {
        this.region = region;
    }

    public Set<AgenceEntity> getAgence() {
        return agence;
    }

    public void setAgence(Set<AgenceEntity> agence) {
        this.agence = agence;
    }


}
