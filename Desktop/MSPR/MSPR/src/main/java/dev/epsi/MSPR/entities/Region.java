package dev.epsi.MSPR.entities;

import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@Entity
@Schema(description = "Représente une région")
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID de la région", example = "1")
    private Long id_region;

    @Schema(description = "Nom de la région", example = "Île-de-France")
    private String nom_region;

    @ManyToOne
    @JoinColumn(name = "id_pays")
    @JsonIgnoreProperties("regions")
    @Schema(description = "Pays associé à la région")
    private Pays pays;

    @OneToMany(mappedBy = "region")
    @Schema(description = "Liste des statistiques associées à la région")
    private List<Statistique> statistiques;

    // Getters & Setters
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
