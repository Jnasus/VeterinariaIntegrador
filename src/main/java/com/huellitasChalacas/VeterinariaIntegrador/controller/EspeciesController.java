/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.controller;

import com.huellitasChalacas.VeterinariaIntegrador.model.Especies;
import com.huellitasChalacas.VeterinariaIntegrador.service.EspeciesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jtorr
 */
@RestController
@RequestMapping("/api/v1/especies")

public class EspeciesController {

    @Autowired
    private EspeciesService especiesService;

    @GetMapping
    public ResponseEntity<List<Especies>> getAllEspecies() {
        List<Especies> especies = especiesService.listarTodasLasEspecies();
        return new ResponseEntity<>(especies, HttpStatus.OK);
    }

    // Obtener una categoría por ID
    @GetMapping("/{id}")
    public ResponseEntity<Especies> getEspeciesById(@PathVariable Integer id) {
        Especies especies = especiesService.obtenerEspeciePorId(id);
        if (especies != null) {
            return new ResponseEntity<>(especies, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Crear una nueva categoría
    @PostMapping
    public ResponseEntity<Especies> createEspecies(@RequestBody Especies especies) {
        Especies newEspecies = especiesService.crearEspecie(especies);
        return new ResponseEntity<>(newEspecies, HttpStatus.CREATED);
    }

    // Actualizar una categoría existente
    @PutMapping("/{id}")
    public ResponseEntity<Especies> updateEspecies(@PathVariable Integer id, @RequestBody Especies especies) {
        Especies existingEspecies = especiesService.obtenerEspeciePorId(id);
        if (existingEspecies != null) {
            especies.setIdEspecie(id); // Asegura que se actualice la categoría correcta
            Especies updatedEspecies = especiesService.crearEspecie(especies);
            return new ResponseEntity<>(updatedEspecies, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar una categoría por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEspecies(@PathVariable Integer id) {
        Especies existingEspecies = especiesService.obtenerEspeciePorId(id);
        if (existingEspecies != null) {
            especiesService.eliminarEspecie(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
