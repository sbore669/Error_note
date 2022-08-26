package com.Errornote.Errornote_api.modele;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Solution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id_solution;
    private String ressource;
    private String temps_consacre;
    private String methodologie_adopte;

}
