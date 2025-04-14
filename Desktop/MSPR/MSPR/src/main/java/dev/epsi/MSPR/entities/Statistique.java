package dev.epsi.MSPR.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;

@Entity
@Schema(description = "Représente une statistique")
public class Statistique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID de la statistique", example = "1")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_maladie")
    @Schema(description = "Maladie associée à la statistique")
    private Maladie maladie;

    @ManyToOne
    @JoinColumn(name = "id_region")
    @JsonBackReference  // 🔧 Empêche boucle infinie en JSON
    @Schema(description = "Région associée à la statistique")
    private Region region;

    @Schema(description = "Date de la statistique", example = "2023-10-01")
    private LocalDate date;

    @Schema(description = "Nombre de nouveaux morts", example = "10")
    private int nouveau_mort;

    @Schema(description = "Nombre de nouveaux cas", example = "100")
    private int nouveau_cas;

    @Schema(description = "Total des morts", example = "200")
    private int total_mort;

    @Schema(description = "Total des cas", example = "1000")
    private int total_cas;

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Maladie getMaladie() {
        return maladie;
    }

    public void setMaladie(Maladie maladie) {
        this.maladie = maladie;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getNouveau_mort() {
        return nouveau_mort;
    }

    public void setNouveau_mort(int nouveau_mort) {
        this.nouveau_mort = nouveau_mort;
    }

    public int getNouveau_cas() {
        return nouveau_cas;
    }

    public void setNouveau_cas(int nouveau_cas) {
        this.nouveau_cas = nouveau_cas;
    }

    public int getTotal_mort() {
        return total_mort;
    }

    public void setTotal_mort(int total_mort) {
        this.total_mort = total_mort;
    }

    public int getTotal_cas() {
        return total_cas;
    }

    public void setTotal_cas(int total_cas) {
        this.total_cas = total_cas;
    }
}