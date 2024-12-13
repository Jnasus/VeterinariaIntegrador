/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.adminController;

import com.huellitasChalacas.VeterinariaIntegrador.dto.TipoDocDTO;
import com.huellitasChalacas.VeterinariaIntegrador.mapper.TipoDocMapper;
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
@RequestMapping("/api/v1/admin/tipodoc")
public class TipoDocAdminController {
    
    @Autowired
    private TipoDocService tipoDocService;
    
    @Autowired
    private TipoDocMapper tipoDocMapper;
    
     // Obtener todos los tipos de documento
    @GetMapping
    public ResponseEntity<List<TipoDocDTO>> getAllTipoDocs() {
        List<TipoDoc> tipoDocs = tipoDocService.findAll();
        List<TipoDocDTO> tipoDocDTOs = tipoDocMapper.toDtoList(tipoDocs);
        return new ResponseEntity<>(tipoDocDTOs, HttpStatus.OK);
    }

    // Obtener un tipo de documento por ID
    @GetMapping("/{id}")
    public ResponseEntity<TipoDocDTO> getTipoDocById(@PathVariable Integer id) {
        TipoDoc tipoDoc = tipoDocService.findById(id);
        if (tipoDoc != null) {
            TipoDocDTO tipoDocDTO = tipoDocMapper.toDTO(tipoDoc);
            return new ResponseEntity<>(tipoDocDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Crear un nuevo tipo de documento
    @PostMapping
    public ResponseEntity<TipoDocDTO> createTipoDoc(@RequestBody TipoDocDTO tipoDocDTO) {
        TipoDoc tipoDoc = tipoDocMapper.toEntity(tipoDocDTO);
        TipoDoc newTipoDoc = tipoDocService.save(tipoDoc);
        TipoDocDTO newTipoDocDTO = tipoDocMapper.toDTO(newTipoDoc);
        return new ResponseEntity<>(newTipoDocDTO, HttpStatus.CREATED);
    }

    // Actualizar un tipo de documento existente
    @PutMapping("/{id}")
    public ResponseEntity<TipoDocDTO> updateTipoDoc(@PathVariable Integer id, @RequestBody TipoDocDTO tipoDocDTO) {
        TipoDoc existingTipoDoc = tipoDocService.findById(id);
        if (existingTipoDoc != null) {
            TipoDoc tipoDoc = tipoDocMapper.toEntity(tipoDocDTO);
            tipoDoc.setIdTipoDoc(id); // Asegura que se actualice la entidad correcta
            TipoDoc updatedTipoDoc = tipoDocService.save(tipoDoc);
            TipoDocDTO updatedTipoDocDTO = tipoDocMapper.toDTO(updatedTipoDoc);
            return new ResponseEntity<>(updatedTipoDocDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar un tipo de documento por ID
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
