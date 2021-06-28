package com.livraison.Livraison.entities;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity(name="ville")
public class VilleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "nom_Ville", length = 225)
    private String nomVille;

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

}
