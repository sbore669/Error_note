package com.Errornote.Errornote_api.modele;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@Setter
@Getter
public class Etat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id_etat;
    private String status;

}
