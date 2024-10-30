/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.controller;

import com.huellitasChalacas.VeterinariaIntegrador.model.TipoServicio;
import com.huellitasChalacas.VeterinariaIntegrador.service.TipoServicioService;
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
@RequestMapping("/api/v1/tipoServicio")
public class TipoServicioController {

    @Autowired
    private TipoServicioService tipoServicioService;
    
     @GetMapping
    public ResponseEntity<List<TipoServicio>> getAllTipoServicios() {
        List<TipoServicio> tipoServicio = tipoServicioService.findAll();
        return new ResponseEntity<>(tipoServicio, HttpStatus.OK);
    }

    // Obtener una categoría por ID
    @GetMapping("/{id}")
    public ResponseEntity<TipoServicio> getTipoServicioById(@PathVariable Integer id) {
        TipoServicio tipoServicio = tipoServicioService.findById(id);
        if (tipoServicio != null) {
            return new ResponseEntity<>(tipoServicio, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Crear una nueva categoría
    @PostMapping
    public ResponseEntity<TipoServicio> createTipoServicio(@RequestBody TipoServicio tipoServicio) {
        TipoServicio newTipoServicio = tipoServicioService.save(tipoServicio);
        return new ResponseEntity<>(newTipoServicio, HttpStatus.CREATED);
    }

    // Actualizar una categoría existente
    @PutMapping("/{id}")
    public ResponseEntity<TipoServicio> updateTipoServicio(@PathVariable Integer id, @RequestBody TipoServicio tipoServicio) {
        TipoServicio existingTipoServicio = tipoServicioService.findById(id);
        if (existingTipoServicio != null) {
            tipoServicio.setIdTipoServicio(id); // Asegura que se actualice la categoría correcta
            TipoServicio updatedTipoServicio = tipoServicioService.save(tipoServicio);
            return new ResponseEntity<>(updatedTipoServicio, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar una categoría por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoServicio(@PathVariable Integer id) {
        TipoServicio existingTipoServicio = tipoServicioService.findById(id);
        if (existingTipoServicio != null) {
            tipoServicioService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
