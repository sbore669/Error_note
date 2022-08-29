package com.Errornote.Errornote_api.controller;

import com.Errornote.Errornote_api.modele.Probleme;
import com.Errornote.Errornote_api.modele.Solution;
import com.Errornote.Errornote_api.services.ProblemeService;
import com.Errornote.Errornote_api.services.SolutionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/probleme")
@AllArgsConstructor
@Api(value = "hello", description = "Les requetes possible sur ma table probleme")
public class ProblemeController {

    private ProblemeService problemeService;
    private SolutionService solutionService;
    @ApiOperation(value = "Permet de creer un probleme")
    @PostMapping("/add")
    public String ajouter(@RequestBody Probleme probleme, Solution solution) {
        problemeService.ajouter(probleme);
        solutionService.ajouter(solution);

        return "Probleme creer avec succes";
    }
    @ApiOperation(value = "Permet de modifier un probleme")
    @PutMapping("/modifier/{id_probleme}")
    public Optional<Optional<Probleme>> modifier(@PathVariable Long id_probleme, @RequestBody Probleme probleme) {
        return Optional.ofNullable(problemeService.modifier(id_probleme, probleme));
    }
    @ApiOperation(value = "Permet de supprimer un probleme")
    @DeleteMapping("supp/{id_probleme}")
    public String supprimer(@PathVariable Long id_probleme) {
        problemeService.supprimer(id_probleme);
        return "Probleme supprimer";
    }
    @ApiOperation(value = "Permet d'affichée un probleme")
    @GetMapping("/aff")
    public List<Probleme> lire() {
        return problemeService.lire();
    }
    @ApiOperation(value = "Permet de recherche un probleme par mots cle")
    @GetMapping("/recherche/{mots_cle}")
    public Object recherche(@PathVariable String mot_cle){
        return problemeService.recherche(mot_cle);
    }





}
