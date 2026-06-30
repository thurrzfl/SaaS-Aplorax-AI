// DietaRepository.java
package com.aplorax.repository;

import com.aplorax.model.Dieta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DietaRepository extends JpaRepository<Dieta, Long> {

    List<Dieta> findByObjetivo(Dieta.Objetivo objetivo);

    List<Dieta> findByCaloriasAlvo(Integer caloriasAlvo);

    List<Dieta> findByCaloriasAlvoBetween(Integer caloriasMin, Integer caloriasMax);
}