package com.livraison.Livraison.entities;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "regions")
public class RegionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "nom_Region", length = 225)
    private String nomRegion;

    @OneToMany(mappedBy = "region")
    private Set<VilleEntity> ville;

    @Column(nullable = false)
    private String RegionId;

    public String getRegionId() {
        return RegionId;
    }

    public void setRegionId(String regionId) {
        RegionId = regionId;
    }

    public RegionEntity() {}



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomRegion() {
        return nomRegion;
    }

    public void setNomRegion(String nomRegion) {
        this.nomRegion = nomRegion;
    }

    public Set<VilleEntity> getVille() {
        return ville;
    }

    public void setVille(Set<VilleEntity> ville) {
        this.ville = ville;
    }

}
