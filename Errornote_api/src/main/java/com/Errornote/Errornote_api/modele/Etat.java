package com.Errornote.Errornote_api.modele;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
@Setter
@Getter
public class Etat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id_etat;
    private String status;


    @ManyToOne
    @JoinColumn(name = "probleme_id_probleme")
    private Probleme probleme;
}
