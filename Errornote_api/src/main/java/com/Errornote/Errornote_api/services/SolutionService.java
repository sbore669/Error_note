package com.Errornote.Errornote_api.services;

import com.Errornote.Errornote_api.modele.Solution;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface SolutionService {
    Solution ajouter(Solution solution);
    Optional<Solution> modifier(Long id_solution, Solution Solution);
    String supprimer(Long id_solution);
    List<Solution> lire();
}
