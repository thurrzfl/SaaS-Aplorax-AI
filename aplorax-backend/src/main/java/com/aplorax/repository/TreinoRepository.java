// TreinoRepository.java
package com.aplorax.repository;

import com.aplorax.model.Treino;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TreinoRepository extends JpaRepository<Treino, Long> {

    List<Treino> findByCategoria(Treino.CategoriaTreino categoria);

    List<Treino> findByNivel(Treino.NivelTreino nivel);

    List<Treino> findByCategoriaAndNivel(Treino.CategoriaTreino categoria, Treino.NivelTreino nivel);
}