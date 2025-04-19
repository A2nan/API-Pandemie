package dev.epsi.MSPR.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;

@Entity
@Schema(description = "Représente un pays")
public class Pays {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID du pays", example = "1")
    private Long id_pays;

    @Schema(description = "Nom du pays", example = "France")
    private String nom_pays;

    @OneToMany(mappedBy = "pays")
    @JsonManagedReference  // 🔧 empêche la récursion infinie
    @Schema(description = "Liste des régions associées au pays")
    private List<Region> regions;

    // Getters & Setters
    public Long getId_pays() {
        return id_pays;
    }

    public void setId_pays(Long id_pays) {
        this.id_pays = id_pays;
    }

    public String getNom_pays() {
        return nom_pays;
    }

    public void setNom_pays(String nom_pays) {
        this.nom_pays = nom_pays;
    }

    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }
}
