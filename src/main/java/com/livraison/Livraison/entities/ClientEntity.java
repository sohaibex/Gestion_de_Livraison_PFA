package com.livraison.Livraison.entities;

import javax.persistence.*;

@Entity(name="client")
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, name="nom_client", length = 225)
    private String nomClient;

    @Column(nullable=false, name="prenom_client", length = 225)
    private String preNomClient;

    @Column(nullable=false, name="tel", length = 225)
    private String tel;

    @Column(nullable=false, name="adresse", length = 325)
    private String adr;

    @OneToOne
    @JoinColumn(name = "id_ville", nullable = false)
    private VilleEntity id_ville;



    public ClientEntity(){}



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getPreNomClient() {
        return preNomClient;
    }

    public void setPreNomClient(String preNomClient) {
        this.preNomClient = preNomClient;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAdr() {
        return adr;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }
    public VilleEntity getId_ville() {
        return id_ville;
    }

    public void setId_ville(VilleEntity id_ville) {
        this.id_ville = id_ville;
    }
}
