/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.controller;

import com.huellitasChalacas.VeterinariaIntegrador.model.Especialidad;
import com.huellitasChalacas.VeterinariaIntegrador.service.EspecialidadService;
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
@RequestMapping("/api/v1/especialidad")
public class EspecialidadController {
    
    @Autowired    
    private EspecialidadService especialidadService;
    
     @GetMapping
    public ResponseEntity<List<Especialidad>> getAllEspecialidad() {
        List<Especialidad> especialidades = especialidadService.findAll();
        return new ResponseEntity<>(especialidades, HttpStatus.OK);
    }

    // Obtener una categoría por ID
    @GetMapping("/{id}")
    public ResponseEntity<Especialidad> getEspecialidadById(@PathVariable Integer id) {
        Especialidad especialidad = especialidadService.findById(id);
        if (especialidad != null) {
            return new ResponseEntity<>(especialidad, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Crear una nueva categoría
    @PostMapping
    public ResponseEntity<Especialidad> createEspecialidad(@RequestBody Especialidad especialidad) {
        Especialidad newEspecialidad = especialidadService.save(especialidad);
        return new ResponseEntity<>(newEspecialidad, HttpStatus.CREATED);
    }

    // Actualizar una categoría existente
    @PutMapping("/{id}")
    public ResponseEntity<Especialidad> updateEspecialidad(@PathVariable Integer id, @RequestBody Especialidad especialidad) {
        Especialidad existingEspecialidad = especialidadService.findById(id);
        if (existingEspecialidad != null) {
            especialidad.setIdEspecialidad(id); // Asegura que se actualice la categoría correcta
            Especialidad updatedEspecialidad = especialidadService.save(especialidad);
            return new ResponseEntity<>(updatedEspecialidad, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar una categoría por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEspecialidad(@PathVariable Integer id) {
        Especialidad existingEspecialidad = especialidadService.findById(id);
        if (existingEspecialidad != null) {
            especialidadService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
