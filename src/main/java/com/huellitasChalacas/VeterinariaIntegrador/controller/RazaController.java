/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.controller;

import com.huellitasChalacas.VeterinariaIntegrador.model.Raza;
import com.huellitasChalacas.VeterinariaIntegrador.service.RazaService;
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
@RequestMapping("/api/v1/raza")
public class RazaController {
    
    @Autowired
    private RazaService razaService;
    
    // Obtener todas las categorías
    @GetMapping
    public ResponseEntity<List<Raza>> getAllRazas() {
        List<Raza> raza = razaService.findAll();
        return new ResponseEntity<>(raza, HttpStatus.OK);
    }

    // Obtener una categoría por ID
    @GetMapping("/{id}")
    public ResponseEntity<Raza> getRazaById(@PathVariable Integer id) {
        Raza raza = razaService.findById(id);
        if (raza != null) {
            return new ResponseEntity<>(raza, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Crear una nueva categoría
    @PostMapping
    public ResponseEntity<Raza> createRaza(@RequestBody Raza raza) {
        Raza newRaza = razaService.save(raza);
        return new ResponseEntity<>(newRaza, HttpStatus.CREATED);
    }

    // Actualizar una categoría existente
    @PutMapping("/{id}")
    public ResponseEntity<Raza> updateRaza(@PathVariable Integer id, @RequestBody Raza raza) {
        Raza existingRaza = razaService.findById(id);
        if (existingRaza != null) {
            raza.setIdRaza(id); // Asegura que se actualice la categoría correcta
            Raza updatedRaza = razaService.save(raza);
            return new ResponseEntity<>(updatedRaza, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar una categoría por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRaza(@PathVariable Integer id) {
        Raza existingRaza = razaService.findById(id);
        if (existingRaza != null) {
            razaService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
        
}
