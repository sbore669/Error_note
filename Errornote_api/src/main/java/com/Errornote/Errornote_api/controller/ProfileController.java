package com.Errornote.Errornote_api.controller;

import com.Errornote.Errornote_api.modele.Profile;
import com.Errornote.Errornote_api.services.ProfileService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profil")
public class ProfileController {
    @Autowired
    ProfileService profileService;

    @PostMapping("/ajouter_profile")
    public Profile ajouter(@RequestBody  Profile profile) {
        return profileService.ajouterProfil(profile);

    }

    @DeleteMapping("/supprimer_profil")
    public void supprimer(@PathVariable Long id){
        profileService.suprrimerProil(id);
    }


}
