package com.Errornote.Errornote_api.ServiceImplemat;

import com.Errornote.Errornote_api.modele.User;
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
    public User ajouter(User user) {
        return userRepo.save(user);
    }

    @Override
    public Optional<User> modifier(Long id_user, User user) {
        return Optional.ofNullable(userRepo.findById(id_user)
                .map(user1 -> {
                    user1.setNom(user.getNom());
                    user1.setPrenom(user.getPrenom());
                    user1.setContact(user.getContact());
                    user1.setPseudo(user.getPseudo());
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
}
