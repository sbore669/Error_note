package com.Errornote.Errornote_api.ServiceImplemat;

import com.Errornote.Errornote_api.modele.Solution;
import com.Errornote.Errornote_api.repository.SolutionRepo;
import com.Errornote.Errornote_api.services.SolutionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SolutionServImpl implements SolutionService {
    private final SolutionRepo solutionRepo;
    @Override
    public Solution ajouter(Solution solution) {
        return solutionRepo.save(solution);
    }

    @Override
    public Optional<Solution> modifier(Long id_solution, Solution solution) {
        return Optional.ofNullable(solutionRepo.findById(id_solution)
                .map(solution1 -> {
                    if(solution.getRessource() !=null)
                    solution1.setRessource(solution.getRessource());
                    if(solution.getTemps_consacre() !=null)

                        solution1.setTemps_consacre(solution.getTemps_consacre());
                    if(solution.getMethodologie_adopte() !=null)

                        solution1.setMethodologie_adopte(solution.getMethodologie_adopte());
                    return solutionRepo.save(solution);
                }).orElseThrow(() -> new RuntimeException("Solution non trouve")));
    }

    @Override
    public String supprimer(Long id_solution) {
        solutionRepo.deleteById(id_solution);
        return "Solution supprimer";
    }

    @Override
    public List<Solution> lire() {
        return solutionRepo.findAll();
    }
}
