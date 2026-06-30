// Exercicio.java
package com.aplorax.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "exercicios")
public class Exercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomeExercicio;

    private Integer series;

    private Integer repeticoes;

    private Integer descansoSegundos;

    @Column(length = 500)
    private String observacoes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "treino_id", nullable = false)
    private Treino treino;
}