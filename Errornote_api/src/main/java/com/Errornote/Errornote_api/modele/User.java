package com.Errornote.Errornote_api.modele;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id_user;
    private String nom;
    private String prenom;
    private String contact;
    private String pseudo;
    private String password;


    @ManyToOne
    @JoinColumn(name = "profile_id_profile")
    private Profile profile;



}
