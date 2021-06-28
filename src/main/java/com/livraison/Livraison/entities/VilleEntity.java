package com.livraison.Livraison.entities;


import javax.persistence.*;

@Entity(name="villes")
public class VilleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "nom_Ville", length = 225)
    private String nomVille;

    @ManyToOne
    @JoinColumn(name="id_region", nullable=false)
    private RegionEntity region;


    public VilleEntity() {

    }

    public VilleEntity(Long id, String nomVille) {
        this.id = id;
        this.nomVille = nomVille;
    }



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

    @Override
    public String toString() {
        return "VilleEntity{" +
                "id=" + id +
                ", nomVille='" + nomVille + '\'' +
                '}';
    }
}
