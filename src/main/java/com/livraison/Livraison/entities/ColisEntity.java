package com.livraison.Livraison.entities;

import javax.persistence.*;

@Entity(name="colis")
public class ColisEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, name="codeColis", length = 225)
    private String codeColis;

    @Column(nullable=false, name="poids")
    private double poids;

    @Column(nullable=false, name="volume")
    private double volume;

    @Column(nullable=false, name="agenceDepart", length = 225)
    private String agenceDepart;

    @Column(nullable=false, name="agenceArrive", length = 225)
    private String agenceArrive;

    @Column(nullable=false, name="adresse", length = 325)
    private String adr;

    @Column(nullable=false, name="fraisLivrison")
    private double fraisLivrison;

    @Column(nullable=false, name="prixUnitaire")
    private double prixU;

    @Column(nullable=false, name="prixTotal")
    private double prixT;

    @OneToOne
    @JoinColumn(name = "id_client", nullable = false)
    private ClientEntity id_client;

    @ManyToOne
    private LivreurEntity livreur;

    @ManyToOne
    private VendeurEntity vendeur;
}
