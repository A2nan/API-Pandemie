package dev.epsi.MSPR.controllers;

import dev.epsi.MSPR.DTO.PaysDto;
import dev.epsi.MSPR.entities.Pays;
import dev.epsi.MSPR.services.PaysService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/pays")
@Tag(name = "Pays", description = "Gestion des pays")
public class PaysController {
    @Autowired
    private PaysService paysService;

    @GetMapping
    public List<PaysDto> getAllPays() {
        return paysService.getAllPays()
                .stream()
                .map(PaysDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Récupérer un pays par ID", description = "Retourne les détails d'un pays spécifique.")
    @ApiResponse(responseCode = "200", description = "Pays récupéré avec succès")
    @ApiResponse(responseCode = "404", description = "Pays non trouvé")
    public Pays getPaysById(@PathVariable Long id) {
        return paysService.getPaysById(id);
    }

    @PostMapping
    @Operation(summary = "Ajouter un pays", description = "Ajoute un nouveau pays.")
    @ApiResponse(responseCode = "201", description = "Pays créé avec succès")
    public Pays createPays(@RequestBody Pays pays) {
        return paysService.createPays(pays);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Mettre à jour un pays", description = "Met à jour les informations d'un pays existant.")
    @ApiResponse(responseCode = "200", description = "Pays mis à jour avec succès")
    @ApiResponse(responseCode = "404", description = "Pays non trouvé")
    public Pays updatePays(@PathVariable Long id, @RequestBody Pays paysDetails) {
        return paysService.updatePays(id, paysDetails);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un pays", description = "Supprime un pays existant.")
    @ApiResponse(responseCode = "204", description = "Pays supprimé avec succès")
    @ApiResponse(responseCode = "404", description = "Pays non trouvé")
    public void deletePays(@PathVariable Long id) {
        paysService.deletePays(id);
    }
}
