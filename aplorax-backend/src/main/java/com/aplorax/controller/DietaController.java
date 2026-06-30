// DietaController.java
package com.aplorax.controller;

import com.aplorax.dto.DietaRequestDTO;
import com.aplorax.model.Dieta;
import com.aplorax.service.DietaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dietas")
@RequiredArgsConstructor
public class DietaController {

    private final DietaService dietaService;

    @PostMapping
    public ResponseEntity<Dieta> criar(@Valid @RequestBody DietaRequestDTO dto) {
        Dieta dieta = dietaService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(dieta);
    }

    @GetMapping
    public ResponseEntity<List<Dieta>> listar(
            @RequestParam(required = false) Dieta.Objetivo objetivo,
            @RequestParam(required = false) Integer calorias,
            @RequestParam(required = false) Integer caloriasMin,
            @RequestParam(required = false) Integer caloriasMax) {

        List<Dieta> dietas;

        if (caloriasMin != null && caloriasMax != null) {
            dietas = dietaService.filtrarPorFaixaCalorica(caloriasMin, caloriasMax);
        } else if (calorias != null) {
            dietas = dietaService.filtrarPorCalorias(calorias);
        } else if (objetivo != null) {
            dietas = dietaService.filtrarPorObjetivo(objetivo);
        } else {
            dietas = dietaService.listarTodos();
        }

        return ResponseEntity.ok(dietas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dieta> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(dietaService.buscarPorId(id));
    }
}