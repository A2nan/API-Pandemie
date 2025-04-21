package dev.epsi.MSPR.repositories;

import dev.epsi.MSPR.entities.Statistique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StatistiqueRepository extends JpaRepository<Statistique, Long> {
    @Query("SELECT s FROM Statistique s WHERE s.region.pays.id_pays = :paysId")
    List<Statistique> findByPaysId(@Param("paysId") Long paysId);

    @Query("SELECT s FROM Statistique s WHERE s.region.pays.id_pays = :paysId AND s.maladie.id_maladie = :maladieId")
    List<Statistique> findByPaysAndMaladie(@Param("paysId") Long paysId, @Param("maladieId") Long maladieId);

    @Query("SELECT s FROM Statistique s WHERE s.maladie.id_maladie = :maladieId")
    List<Statistique> findByMaladie(@Param("maladieId") Long maladieId);

}