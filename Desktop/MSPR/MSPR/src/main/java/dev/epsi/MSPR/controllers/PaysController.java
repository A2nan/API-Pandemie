package dev.epsi.MSPR.controllers;

import dev.epsi.MSPR.entities.Pays;
import dev.epsi.MSPR.services.PaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pays")
public class PaysController {
    @Autowired
    private PaysService paysService;

    @GetMapping
    public List<Pays> getAllPays() {
        return paysService.getAllPays();
    }

    @GetMapping("/{id}")
    public Pays getPaysById(@PathVariable Long id) {
        return paysService.getPaysById(id);
    }

    @PostMapping
    public Pays createPays(@RequestBody Pays pays) {
        return paysService.createPays(pays);
    }

    @PutMapping("/{id}")
    public Pays updatePays(@PathVariable Long id, @RequestBody Pays paysDetails) {
        return paysService.updatePays(id, paysDetails);
    }

    @DeleteMapping("/{id}")
    public void deletePays(@PathVariable Long id) {
        paysService.deletePays(id);
    }
}
