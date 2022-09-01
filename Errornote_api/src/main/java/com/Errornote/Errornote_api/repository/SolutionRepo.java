package com.Errornote.Errornote_api.repository;

import com.Errornote.Errornote_api.modele.Probleme;
import com.Errornote.Errornote_api.modele.Solution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolutionRepo extends JpaRepository<Solution, Long> {
    //definition de la methode : trouver la solution à partir du probleme
    Solution findByProbleme(Probleme probleme);

}
