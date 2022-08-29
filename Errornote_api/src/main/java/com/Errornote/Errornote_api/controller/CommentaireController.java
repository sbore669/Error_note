package com.Errornote.Errornote_api.controller;

import com.Errornote.Errornote_api.modele.Commentaire;
import com.Errornote.Errornote_api.repository.CommentaireRepo;
import com.Errornote.Errornote_api.services.CommentaireService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cmt")
@AllArgsConstructor
@Api(value = "hello", description = "Les requetes possible sur ma table commentaire")
public class CommentaireController {

    private final CommentaireService commentaireService;

    @ApiOperation(value = "Permet de creer un commentaire")
    @PostMapping("/add")
    public Commentaire ajouter(@RequestBody Commentaire commentaire) {

        return commentaireService.ajouter(commentaire);
    }

    @ApiOperation(value = "Permet de modifier un commentaire")
    @PutMapping("/modifier/{id_commentaire}")
    public Commentaire modifier(@PathVariable Long id_commentaire, @RequestBody Commentaire commentaire) {
        return commentaireService.modifier(id_commentaire,commentaire);}

    @ApiOperation(value = "Permet d'affichée un commentaire")
    @GetMapping("/affichéé")
    public List<Commentaire> lire() {
        return commentaireService.lire();
    }

    @ApiOperation(value = "Permet de supprimer un commentaire")
    @DeleteMapping("/suppr/{id_commentaire}")
    public String supprimer(@PathVariable Long id_commentaire) {
        commentaireService.supprimer(id_commentaire);
        return "Vous venez de supprimé votre commentaire";
    }


}
