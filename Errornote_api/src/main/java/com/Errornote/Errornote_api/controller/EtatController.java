package com.Errornote.Errornote_api.controller;

import com.Errornote.Errornote_api.modele.Etat;
import com.Errornote.Errornote_api.services.EtatService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etat")
@AllArgsConstructor
@Api(value = "hello", description = "Les requetes possible sur ma table Etat")
public class EtatController {

    private final EtatService etatService;
    @ApiOperation(value = "Permet de creer un Etat")
    @PostMapping("/add")
    public Etat ajouter(@RequestBody Etat etat) {
        return etatService.ajouter(etat);
    }
    @ApiOperation(value = "Permet de modifier un Etat")
    @PutMapping("/modifier")
    public Etat modifier(@PathVariable Long id_etat) {
        return etatService.modifier(id_etat);}

    @ApiOperation(value = "Permet d'affichée un Etat")
    @GetMapping("/aff")
    public List<Etat> lire() {
        return etatService.lire();
    }

}
