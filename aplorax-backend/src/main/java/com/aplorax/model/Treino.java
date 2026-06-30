// Treino.java
package com.aplorax.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "treinos")
public class Treino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(length = 1000)
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CategoriaTreino categoria;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NivelTreino nivel;

    @OneToMany(mappedBy = "treino", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Exercicio> exercicios = new ArrayList<>();

    // Enums
    public enum CategoriaTreino {
        MUSCULACAO,
        AEROBICO,
        CROSSFIT
    }

    public enum NivelTreino {
        INICIANTE,
        INTERMEDIARIO,
        AVANCADO
    }
}