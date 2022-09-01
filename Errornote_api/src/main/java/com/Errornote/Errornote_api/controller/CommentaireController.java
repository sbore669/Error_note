package com.Errornote.Errornote_api.controller;

import com.Errornote.Errornote_api.modele.Commentaire;
import com.Errornote.Errornote_api.modele.Probleme;
import com.Errornote.Errornote_api.modele.Solution;
import com.Errornote.Errornote_api.modele.User;
import com.Errornote.Errornote_api.repository.CommentaireRepo;
import com.Errornote.Errornote_api.repository.ProblemeRepo;
import com.Errornote.Errornote_api.repository.SolutionRepo;
import com.Errornote.Errornote_api.repository.UserRepo;
import com.Errornote.Errornote_api.services.CommentaireService;
import com.Errornote.Errornote_api.services.ProblemeService;
import com.Errornote.Errornote_api.services.SolutionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commenter")
@AllArgsConstructor
@Api(value = "hello", description = "Les requetes possible sur ma table commentaire")
public class CommentaireController {

    private final CommentaireService commentaireService;
    private final CommentaireRepo commentaireRepo;
    private final UserRepo userRepo;
    private final ProblemeRepo problemeRepo;
    private final ProblemeService problemeService;
    private final SolutionService solutionService;
    private final SolutionRepo solutionRepo;

    @ApiOperation(value = "Permet de creer un commentaire")
    @PostMapping("/add/{pseudo}/{password}/{titre}")
    public String ajouter(@RequestBody Commentaire commentaire, @PathVariable  String pseudo, @PathVariable  String password, @PathVariable String titre) {
       //verification de user à partir de son email(pour voir si le pseudo entrée dans l'url  est dans la base de donnée)
        User user= userRepo.findByPseudo( pseudo);
        //verification de user à partir de son password(pour voir si le password entrée dans l'url  est dans la base de donnée)
       // User user1= userRepo.findByPassword(password);
        //appels des problemes à travers leurs titres
        Probleme probleme=problemeService.trouverproblemepartitre(titre);

        //vu qu'on cherche la solution à partir du probleme
        //on verifie d'abord si le probleme existe
        if(probleme !=null){
            //si le probleme existe alors
            //on cherche la solution à partir du probleme
            Solution solution= solutionRepo.findByProbleme(probleme);
            if(solution !=null){
                if(user != null){
                    if(password == user.getPassword() ){
                        commentaireService.ajouter(commentaire);
                        return "Votre Commentaire a bien été ajouter";
                    }
                    else {
                        return "mots de passe incorrect";
                    }


                }
                else {
                    return "Vous ne pouvez pas faire de commentaire sans être enregistrer.Veuillez donc vous enregistrer";
                }

            }
            return "Ce probleme n'a pas encore été solutionner vous ne pouvez donc pas la commenter";
        }

        return "Leproblème n'existe pas donc la solution non plus vous ne pouvez cependant pas la commenter";
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
