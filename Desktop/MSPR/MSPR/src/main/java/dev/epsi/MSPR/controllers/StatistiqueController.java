package dev.epsi.MSPR.controllers;

import dev.epsi.MSPR.entities.Statistique;
import dev.epsi.MSPR.repositories.StatistiqueRepository;
import dev.epsi.MSPR.services.StatistiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/statistiques")
@Tag(name = "Statistique", description = "Gestion des statistiques")
public class StatistiqueController {

    private final StatistiqueService statistiqueService;
    private final StatistiqueRepository statistiqueRepository;

    // ✅ Constructeur pour injecter les dépendances (recommandé)
    @Autowired
    public StatistiqueController(StatistiqueService statistiqueService, StatistiqueRepository statistiqueRepository) {
        this.statistiqueService = statistiqueService;
        this.statistiqueRepository = statistiqueRepository;
    }

    @GetMapping
    @Operation(summary = "Récupérer toutes les statistiques", description = "Retourne une liste de toutes les statistiques.")
    @ApiResponse(responseCode = "200", description = "Liste des statistiques récupérée avec succès")
    public List<Statistique> getAllStatistiques() {
        return statistiqueService.getAllStatistiques();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Récupérer une statistique par ID", description = "Retourne les détails d'une statistique spécifique.")
    @ApiResponse(responseCode = "200", description = "Statistique récupérée avec succès")
    @ApiResponse(responseCode = "404", description = "Statistique non trouvée")
    public Statistique getStatistiqueById(@PathVariable Long id) {
        return statistiqueService.getStatistiqueById(id);
    }

    @PostMapping
    @Operation(summary = "Ajouter une statistique", description = "Ajoute une nouvelle statistique.")
    @ApiResponse(responseCode = "201", description = "Statistique créée avec succès")
    public Statistique createStatistique(@RequestBody Statistique statistique) {
        return statistiqueService.createStatistique(statistique);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Mettre à jour une statistique", description = "Met à jour les informations d'une statistique existante.")
    @ApiResponse(responseCode = "200", description = "Statistique mise à jour avec succès")
    @ApiResponse(responseCode = "404", description = "Statistique non trouvée")
    public Statistique updateStatistique(@PathVariable Long id, @RequestBody Statistique statistiqueDetails) {
        return statistiqueService.updateStatistique(id, statistiqueDetails);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer une statistique", description = "Supprime une statistique existante.")
    @ApiResponse(responseCode = "204", description = "Statistique supprimée avec succès")
    @ApiResponse(responseCode = "404", description = "Statistique non trouvée")
    public void deleteStatistique(@PathVariable Long id) {
        statistiqueService.deleteStatistique(id);
    }

    @GetMapping("/donnees-par-jour")
    public List<Map<String, Object>> getDonneesParJour(
            @RequestParam Long paysId,
            @RequestParam Long maladieId,
            @RequestParam String type
    ) {
        List<Statistique> stats = statistiqueRepository.findByPaysAndMaladie(paysId, maladieId);

        return stats.stream()
                .collect(Collectors.groupingBy(
                        Statistique::getDate,
                        TreeMap::new,
                        Collectors.summingInt(s -> {
                            return switch (type) {
                                case "nouveau_mort" -> s.getNouveau_mort();
                                case "nouveau_cas" -> s.getNouveau_cas();
                                case "total_mort" -> s.getTotal_mort();
                                case "total_cas" -> s.getTotal_cas();
                                default -> 0;
                            };
                        })
                ))
                .entrySet().stream()
                .map(entry -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("date", entry.getKey());
                    map.put("valeur", entry.getValue());
                    return map;
                })
                .collect(Collectors.toList());
    }

    @GetMapping("/top-pays-morts")
    public List<Map<String, Object>> getTopPaysParMortsTotaux(@RequestParam Long maladieId) {
        List<Statistique> stats = statistiqueRepository.findByMaladie(maladieId);

        Map<String, Integer> mortsParPays = new HashMap<>();
        for (Statistique s : stats) {
            if (s.getRegion() != null && s.getRegion().getPays() != null) {
                String nomPays = s.getRegion().getPays().getNom_pays();
                mortsParPays.put(nomPays, mortsParPays.getOrDefault(nomPays, 0) + s.getTotal_mort());
            }
        }

        return mortsParPays.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(5)
                .map(e -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("pays", e.getKey());
                    map.put("total", e.getValue());
                    return map;
                })
                .collect(Collectors.toList());
    }
}
