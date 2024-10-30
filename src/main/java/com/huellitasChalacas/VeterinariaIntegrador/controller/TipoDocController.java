/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.controller;

import com.huellitasChalacas.VeterinariaIntegrador.model.TipoDoc;
import com.huellitasChalacas.VeterinariaIntegrador.service.TipoDocService;
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
@RequestMapping("/api/v1/tipoDoc")
public class TipoDocController {

    @Autowired
    private TipoDocService tipoDocService;
    
    // Obtener todas las categorías
    @GetMapping
    public ResponseEntity<List<TipoDoc>> getAllTipoDocs() {
        List<TipoDoc> TipoDocs = tipoDocService.findAll();
        return new ResponseEntity<>(TipoDocs, HttpStatus.OK);
    }

    // Obtener una categoría por ID
    @GetMapping("/{id}")
    public ResponseEntity<TipoDoc> getTipoDocById(@PathVariable Integer id) {
        TipoDoc tipoDoc = tipoDocService.findById(id);
        if (tipoDoc != null) {
            return new ResponseEntity<>(tipoDoc, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Crear una nueva categoría
    @PostMapping
    public ResponseEntity<TipoDoc> createTipoDoc(@RequestBody TipoDoc tipoDoc) {
        TipoDoc newTipoDoc = tipoDocService.save(tipoDoc);
        return new ResponseEntity<>(newTipoDoc, HttpStatus.CREATED);
    }

    // Actualizar una categoría existente
    @PutMapping("/{id}")
    public ResponseEntity<TipoDoc> updateTipoDoc(@PathVariable Integer id, @RequestBody TipoDoc tipoDoc) {
        TipoDoc existingTipoDoc = tipoDocService.findById(id);
        if (existingTipoDoc != null) {
            tipoDoc.setIdTipoDoc(id); // Asegura que se actualice la categoría correcta
            TipoDoc updatedTipoDoc = tipoDocService.save(tipoDoc);
            return new ResponseEntity<>(updatedTipoDoc, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar una categoría por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoDoc(@PathVariable Integer id) {
        TipoDoc existingTipoDoc = tipoDocService.findById(id);
        if (existingTipoDoc != null) {
            tipoDocService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
