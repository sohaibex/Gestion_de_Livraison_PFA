package com.livraison.Livraison.entities;

import javax.persistence.*;

@Entity(name="statue")
public class StatueEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, name="statueColis", length = 225)
    private String statueColis;



    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
