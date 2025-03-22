package dev.epsi.MSPR.services;

import dev.epsi.MSPR.entities.Pays;
import dev.epsi.MSPR.repositories.PaysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaysService {
    @Autowired
    private PaysRepository paysRepository;

    public List<Pays> getAllPays() {
        return paysRepository.findAll();
    }

    public Pays getPaysById(Long id) {
        return paysRepository.findById(id).orElse(null);
    }

    public Pays createPays(Pays pays) {
        return paysRepository.save(pays);
    }

    public Pays updatePays(Long id, Pays paysDetails) {
        Pays pays = paysRepository.findById(id).orElse(null);
        if (pays != null) {
            pays.setNom_pays(paysDetails.getNom_pays());
            return paysRepository.save(pays);
        }
        return null;
    }

    public void deletePays(Long id) {
        paysRepository.deleteById(id);
    }
}