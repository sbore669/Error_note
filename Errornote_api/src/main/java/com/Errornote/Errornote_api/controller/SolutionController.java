package com.Errornote.Errornote_api.controller;

import com.Errornote.Errornote_api.modele.Solution;
import com.Errornote.Errornote_api.services.SolutionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/solution")
@AllArgsConstructor
@Api(value = "hello", description = "Les requetes possible sur ma table solution")
public class SolutionController {

    private final SolutionService solutionService;
    @ApiOperation(value = "Permet de creer une solution")
    @PostMapping("/add")
    public Solution ajouter(@RequestBody Solution solution) {

        return solutionService.ajouter(solution);
    }
    @ApiOperation(value = "Permet de modifier une solution")
    @PutMapping("/modifier/{id_solution}")
    public Optional<Solution> modifier(@PathVariable Long id_solution, @RequestBody Solution solution) {
        return solutionService.modifier(id_solution,solution);}
    @ApiOperation(value = "Permet d'affichée une solution")
    @GetMapping("/aff")
    public List<Solution> lire() {
        return solutionService.lire();
    }
    @ApiOperation(value = "Permet de supprimer une solution")
    @DeleteMapping("/suppr/{id_solution}")
    public String supprimer(Long id_solution) {
        solutionService.supprimer(id_solution);
        return "Vous venez de supprimé votre commentaire";
    }
}
