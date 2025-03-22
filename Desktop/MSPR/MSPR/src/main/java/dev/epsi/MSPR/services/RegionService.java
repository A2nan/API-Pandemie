package dev.epsi.MSPR.services;

import dev.epsi.MSPR.entities.Region;
import dev.epsi.MSPR.repositories.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RegionService {
    @Autowired
    private RegionRepository regionRepository;

    public List<Region> getAllRegions() {
        return regionRepository.findAll();
    }

    public Region getRegionById(Long id) {
        return regionRepository.findById(id).orElse(null);
    }

    public Region createRegion(Region region) {
        return regionRepository.save(region);
    }

    public Region updateRegion(Long id, Region regionDetails) {
        Region region = regionRepository.findById(id).orElse(null);
        if (region != null) {
            region.setNom_region(regionDetails.getNom_region());
            region.setPays(regionDetails.getPays());
            return regionRepository.save(region);
        }
        return null;
    }

    public void deleteRegion(Long id) {
        regionRepository.deleteById(id);
    }
}