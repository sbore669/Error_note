package com.Errornote.Errornote_api.controller;

import com.Errornote.Errornote_api.modele.Profile;
import com.Errornote.Errornote_api.modele.User;
import com.Errornote.Errornote_api.services.ProfileService;
import com.Errornote.Errornote_api.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
@Api(value = "hello", description = "Les requetes possible sur ma table user")
public class UserController {

    private final UserService userService;

    private final ProfileService profileService;
    @ApiOperation(value = "Permet de creer une utilisateur")
    @PostMapping("/creer_compte/{profil}")
    public String CreerCompte(@RequestBody User user, @PathVariable("profil") String profil){

        Profile profil1 = profileService.trouverProfilParLibelle(profil);
        if (userService.Seconnecter(user.getPseudo(), user.getPassword())) {
            return "CE COMPTE EXISTE DEJA";
        }
        else
        {
            user.setProfile(profil1);
            userService.CreerUser(user);
            return "COMPTE CREER AVEC SUCCES";
        }

    }
    @ApiOperation(value = "Permet de modifier un utilisateur")
    @PutMapping("/modifier/{id_user}")
    public Optional<Optional<User>> modifier(@PathVariable Long id_user, @RequestBody User user) {
        return Optional.ofNullable(userService.modifier(id_user, user));
    }
    @ApiOperation(value = "Permet de supprimer une utilisateur")
    @DeleteMapping("/supp/{id_user}")
    public String supprimer(@PathVariable Long id_user) {
        userService.supprimer(id_user);
        return "User supprimer";
    }
    @ApiOperation(value = "Permet d'affichée un utilisateur")
    @GetMapping("/aff")
    public List<User> lire() {
        return userService.lire();
    }


}
