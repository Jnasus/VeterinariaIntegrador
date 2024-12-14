/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.adminController;

import com.huellitasChalacas.VeterinariaIntegrador.dto.TipoServicioDTO;
import com.huellitasChalacas.VeterinariaIntegrador.mapper.TipoServicioMapper;
import com.huellitasChalacas.VeterinariaIntegrador.model.TipoServicio;
import com.huellitasChalacas.VeterinariaIntegrador.service.TipoServicioService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author jtorr
 */
@RestController
@RequestMapping("/api/v1/admin/tiposervicio")
public class TipoServicioAdminController {

    @Autowired
    private TipoServicioService tipoServicioService;

    @Autowired
    private TipoServicioMapper tipoServicioMapper;

    // Obtener todas las categorías de productos
    @GetMapping
    public ResponseEntity<List<TipoServicioDTO>> getAllCategoriasProducto() {
        List<TipoServicio> tipoServicios = tipoServicioService.findAll();
        List<TipoServicioDTO> tipoServicioDTOs = tipoServicioMapper.toDtoList(tipoServicios);
        return new ResponseEntity<>(tipoServicioDTOs, HttpStatus.OK);
    }

    // Obtener una categoría de producto por ID
    @GetMapping("/{id}")
    public ResponseEntity<TipoServicioDTO> getTipoServicioById(@PathVariable Integer id) {
        TipoServicio tipoServicio = tipoServicioService.findById(id);
        if (tipoServicio != null) {
            TipoServicioDTO tipoServicioDTO = tipoServicioMapper.toDTO(tipoServicio);
            return new ResponseEntity<>(tipoServicioDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Crear una nueva categoría de producto
    @PostMapping
    public ResponseEntity<TipoServicioDTO> createTipoServicio(@RequestBody TipoServicioDTO tipoServicioDTO) {
        TipoServicio tipoServicio = tipoServicioMapper.toEntity(tipoServicioDTO);
        TipoServicio newTipoServicio = tipoServicioService.save(tipoServicio);
        TipoServicioDTO newTipoServicioDTO = tipoServicioMapper.toDTO(newTipoServicio);
        return new ResponseEntity<>(newTipoServicioDTO, HttpStatus.CREATED);
    }

    // Actualizar una categoría de producto existente
    @PutMapping("/{id}")
    public ResponseEntity<TipoServicioDTO> updateTipoServicio(@PathVariable Integer id, @RequestBody TipoServicioDTO tipoServicioDTO) {
        TipoServicio existingTipoServicio = tipoServicioService.findById(id);
        if (existingTipoServicio != null) {
            TipoServicio tipoServicio = tipoServicioMapper.toEntity(tipoServicioDTO);
            tipoServicio.setIdTipoServicio(id); // Asegura que se actualice la categoría correcta
            TipoServicio updatedTipoServicio = tipoServicioService.save(tipoServicio);
            TipoServicioDTO updatedTipoServicioDTO = tipoServicioMapper.toDTO(updatedTipoServicio);
            return new ResponseEntity<>(updatedTipoServicioDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar una categoría de producto por ID
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
