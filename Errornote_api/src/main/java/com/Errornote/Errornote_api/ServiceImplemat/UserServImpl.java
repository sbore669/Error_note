package com.Errornote.Errornote_api.ServiceImplemat;

import com.Errornote.Errornote_api.modele.User;
import com.Errornote.Errornote_api.repository.ProfileRepository;
import com.Errornote.Errornote_api.repository.UserRepo;
import com.Errornote.Errornote_api.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServImpl implements UserService {
    private final UserRepo userRepo;

    @Override
    public User CreerUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public Optional<User> modifier(Long id_user, User user) {
        return Optional.ofNullable(userRepo.findById(id_user)
                .map(user1 -> {
                    if(user.getNom() !=null)
                    user1.setNom(user.getNom());
                    if(user.getPrenom() !=null)
                    user1.setPrenom(user.getPrenom());
                    if(user.getContact() !=null)
                    user1.setContact(user.getContact());
                    if(user.getPseudo() !=null)
                    user1.setPseudo(user.getPseudo());
                    if(user.getEmail() !=null)
                    user1.setEmail(user.getEmail());
                    if(user.getPassword() !=null)
                    user1.setPassword(user.getPassword());
                    return userRepo.save(user);

                }).orElseThrow(() -> new RuntimeException("User modifier")));
    }

    @Override
    public String supprimer(Long id_user) {
         userRepo.deleteById(id_user);
        return "User supprimer";

    }

    @Override
    public List<User> lire() {
        return userRepo.findAll();
    }

    @Override
    public boolean Seconnecter(String pseudo, String password) {
        if ((userRepo.findByPseudo(pseudo) == null) || userRepo.findByPassword(password) == null)
        return false ;
        else
            return true;
    }
}
