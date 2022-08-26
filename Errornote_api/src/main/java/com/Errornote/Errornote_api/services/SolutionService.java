package com.Errornote.Errornote_api.services;

import com.Errornote.Errornote_api.modele.Probleme;
import com.Errornote.Errornote_api.modele.Profil;
import com.Errornote.Errornote_api.modele.Solution;

import java.util.List;
import java.util.Optional;

public interface SolutionService {
    Solution ajouter(Solution solution);
    Optional<Solution> modifier(Long id_solution, Solution Solution);
    String supprimer(Long id_solution);
    List<Solution> lire();
}
