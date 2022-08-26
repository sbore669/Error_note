package com.Errornote.Errornote_api.modele;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Probleme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id_probleme;
    private String titre;
    private String description;
    private String tecno_concerne;

}
