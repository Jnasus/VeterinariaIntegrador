/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.controller;

import com.huellitasChalacas.VeterinariaIntegrador.model.Veterinario;
import com.huellitasChalacas.VeterinariaIntegrador.service.VeterinarioService;
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
@RequestMapping("/api/v1/veterinario")
public class VeterinarioController {
    
    @Autowired
    private VeterinarioService veterinarioService;
    
    @GetMapping
    public ResponseEntity<List<Veterinario>> getAllVeterinarios() {
        List<Veterinario> veterinario = veterinarioService.findAll();
        return new ResponseEntity<>(veterinario, HttpStatus.OK);
    }

    // Obtener una categoría por ID
    @GetMapping("/{id}")
    public ResponseEntity<Veterinario> getVeterinarioById(@PathVariable Integer id) {
        Veterinario veterinario = veterinarioService.findById(id);
        if (veterinario != null) {
            return new ResponseEntity<>(veterinario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Crear una nueva categoría
    @PostMapping
    public ResponseEntity<Veterinario> createVeterinario(@RequestBody Veterinario veterinario) {
        Veterinario newVeterinario = veterinarioService.save(veterinario);
        return new ResponseEntity<>(newVeterinario, HttpStatus.CREATED);
    }

    // Actualizar una categoría existente
    @PutMapping("/{id}")
    public ResponseEntity<Veterinario> updateVeterinario(@PathVariable Integer id, @RequestBody Veterinario veterinario) {
        Veterinario existingVeterinario = veterinarioService.findById(id);
        if (existingVeterinario != null) {
            veterinario.setIdPersona(id); // Asegura que se actualice la categoría correcta
            Veterinario updatedVeterinario = veterinarioService.save(veterinario);
            return new ResponseEntity<>(updatedVeterinario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar una categoría por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVeterinario(@PathVariable Integer id) {
        Veterinario existingVeterinario = veterinarioService.findById(id);
        if (existingVeterinario != null) {
            veterinarioService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
}
