package dev.epsi.MSPR.controllers;

import dev.epsi.MSPR.DTO.RegionDto;
import dev.epsi.MSPR.entities.Region;
import dev.epsi.MSPR.services.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;


@RestController
@RequestMapping("/api/regions")
@Tag(name = "Region", description = "Gestion des régions")
public class RegionController {
    @Autowired
    private RegionService regionService;

    @GetMapping
    public List<RegionDto> getAllRegions() {
        return regionService.getAllRegions()
                .stream()
                .map(RegionDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Récupérer une région par ID", description = "Retourne les détails d'une région spécifique.")
    @ApiResponse(responseCode = "200", description = "Région récupérée avec succès")
    @ApiResponse(responseCode = "404", description = "Région non trouvée")
    public Region getRegionById(@PathVariable Long id) {
        return regionService.getRegionById(id);
    }

    @PostMapping
    @Operation(summary = "Ajouter une région", description = "Ajoute une nouvelle région.")
    @ApiResponse(responseCode = "201", description = "Région créée avec succès")
    public Region createRegion(@RequestBody Region region) {
        return regionService.createRegion(region);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Mettre à jour une région", description = "Met à jour les informations d'une région existante.")
    @ApiResponse(responseCode = "200", description = "Région mise à jour avec succès")
    @ApiResponse(responseCode = "404", description = "Région non trouvée")
    public Region updateRegion(@PathVariable Long id, @RequestBody Region regionDetails) {
        return regionService.updateRegion(id, regionDetails);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer une région", description = "Supprime une région existante.")
    @ApiResponse(responseCode = "204", description = "Région supprimée avec succès")
    @ApiResponse(responseCode = "404", description = "Région non trouvée")
    public void deleteRegion(@PathVariable Long id) {
        regionService.deleteRegion(id);
    }
}