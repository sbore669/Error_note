package com.Errornote.Errornote_api.repository;

import com.Errornote.Errornote_api.modele.Probleme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ProblemeRepo extends JpaRepository<Probleme, Long> {
    @Query(value = "Select * from probleme WHERE probleme.titre LIKE %?1% " + " OR probleme.description LIKE %?1%", nativeQuery = true)

    List<Probleme> findAll(String mot_cle);

}
