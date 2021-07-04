package com.livraison.Livraison.entities;

import javax.persistence.*;
import java.util.Set;

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
    @JoinColumn(name = "statue", nullable = false)
    private StatueEntity statue;

    @OneToOne
    @JoinColumn(name = "id_client", nullable = false)
    private ClientEntity id_client;

    @ManyToOne
    private LivreurEntity livreur;

    @ManyToOne
    private VendeurEntity vendeur;

    @ManyToMany
    Set<AgenceEntity> agences;

    public ColisEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeColis() {
        return codeColis;
    }

    public void setCodeColis(String codeColis) {
        this.codeColis = codeColis;
    }

    public double getPoids() {
        return poids;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public String getAgenceDepart() {
        return agenceDepart;
    }

    public void setAgenceDepart(String agenceDepart) {
        this.agenceDepart = agenceDepart;
    }

    public String getAgenceArrive() {
        return agenceArrive;
    }

    public void setAgenceArrive(String agenceArrive) {
        this.agenceArrive = agenceArrive;
    }

    public String getAdr() {
        return adr;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }

    public double getFraisLivrison() {
        return fraisLivrison;
    }

    public void setFraisLivrison(double fraisLivrison) {
        this.fraisLivrison = fraisLivrison;
    }

    public double getPrixU() {
        return prixU;
    }

    public void setPrixU(double prixU) {
        this.prixU = prixU;
    }

    public double getPrixT() {
        return prixT;
    }

    public void setPrixT(double prixT) {
        this.prixT = prixT;
    }

    public StatueEntity getStatue() {
        return statue;
    }

    public void setStatue(StatueEntity statue) {
        this.statue = statue;
    }

    public ClientEntity getId_client() {
        return id_client;
    }

    public void setId_client(ClientEntity id_client) {
        this.id_client = id_client;
    }

    public LivreurEntity getLivreur() {
        return livreur;
    }

    public void setLivreur(LivreurEntity livreur) {
        this.livreur = livreur;
    }

    public VendeurEntity getVendeur() {
        return vendeur;
    }

    public void setVendeur(VendeurEntity vendeur) {
        this.vendeur = vendeur;
    }

    public Set<AgenceEntity> getAgences() {
        return agences;
    }

    public void setAgences(Set<AgenceEntity> agences) {
        this.agences = agences;
    }
}
