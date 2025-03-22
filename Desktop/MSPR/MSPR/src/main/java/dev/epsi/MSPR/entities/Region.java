package dev.epsi.MSPR.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_region;
    private String nom_region;

    @ManyToOne
    @JoinColumn(name = "id_pays")
    private Pays pays;

    @OneToMany(mappedBy = "region")
    private List<Statistique> statistiques;

    public Long getId_region() {
        return id_region;
    }

    public void setId_region(Long id_region) {
        this.id_region = id_region;
    }

    public String getNom_region() {
        return nom_region;
    }

    public void setNom_region(String nom_region) {
        this.nom_region = nom_region;
    }

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }

    public List<Statistique> getStatistiques() {
        return statistiques;
    }

    public void setStatistiques(List<Statistique> statistiques) {
        this.statistiques = statistiques;
    }
}