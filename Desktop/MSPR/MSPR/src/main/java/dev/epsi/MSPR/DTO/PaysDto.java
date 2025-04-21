package dev.epsi.MSPR.DTO;

import dev.epsi.MSPR.entities.Pays;
import dev.epsi.MSPR.entities.Region;

import java.util.List;
import java.util.stream.Collectors;

public class PaysDto {
    private Long id_pays;
    private String nom_pays;
    private List<Long> regions;

    public PaysDto(Pays pays) {
        this.id_pays = pays.getId_pays(); // ✅ on revient sur id_pays
        this.nom_pays = pays.getNom_pays();
        this.regions = pays.getRegions() != null
                ? pays.getRegions().stream().map(Region::getId_region).collect(Collectors.toList())
                : List.of();
    }

    public Long getId_pays() {
        return id_pays;
    }

    public String getNom_pays() {
        return nom_pays;
    }

    public List<Long> getRegions() {
        return regions;
    }
}
