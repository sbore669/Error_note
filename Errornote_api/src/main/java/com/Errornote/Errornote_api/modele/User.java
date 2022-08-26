package com.Errornote.Errornote_api.modele;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

}
