// desenvolvido por arthur
// data 28/06/2026

package com.aplorax.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    // Perfil físico
    private Double weight;
    private Double height;
    private Integer age;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private Goal goal;

    @Enumerated(EnumType.STRING)
    private ActivityLevel activityLevel;

    // Enums
    public enum Gender {
        MALE, FEMALE
    }

    public enum Goal {
        LOSE_WEIGHT,
        GAIN_MUSCLE,
        MAINTAIN
    }

    public enum ActivityLevel {
        SEDENTARY, // Sedentário
        LIGHT, // Levemente ativo (1-3x/sem)
        MODERATE, // Moderado (3-5x/sem)
        VERY_ACTIVE, // Muito ativo (6-7x/sem)
        ATHLETE // Atleta pesado
    }

}