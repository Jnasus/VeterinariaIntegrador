/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.adminController;

import com.huellitasChalacas.VeterinariaIntegrador.dto.CitasDTO;
import com.huellitasChalacas.VeterinariaIntegrador.mapper.CitasMapper;
import com.huellitasChalacas.VeterinariaIntegrador.model.Citas;
import com.huellitasChalacas.VeterinariaIntegrador.service.CitasService;
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
@RequestMapping("/api/v1/admin/citas")
public class CitasAdminController {

    @Autowired
    private CitasService citasService;

    @Autowired
    private CitasMapper citasMapper;

    // Obtener todas las categorías de productos
    @GetMapping
    public ResponseEntity<List<CitasDTO>> getAllCategoriasProducto() {
        List<Citas> citass = citasService.findAll();
        List<CitasDTO> citasDTOs = citasMapper.toDtoList(citass);
        return new ResponseEntity<>(citasDTOs, HttpStatus.OK);
    }

    // Obtener una categoría de producto por ID
    @GetMapping("/{id}")
    public ResponseEntity<CitasDTO> getCitasById(@PathVariable Integer id) {
        Citas citas = citasService.findById(id);
        if (citas != null) {
            CitasDTO citasDTO = citasMapper.toDto(citas);
            return new ResponseEntity<>(citasDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Crear una nueva categoría de producto
    @PostMapping
    public ResponseEntity<CitasDTO> createCitas(@RequestBody CitasDTO citasDTO) {
        Citas citas = citasMapper.toEntity(citasDTO);
        Citas newCitas = citasService.save(citas);
        CitasDTO newCitasDTO = citasMapper.toDto(newCitas);
        return new ResponseEntity<>(newCitasDTO, HttpStatus.CREATED);
    }

    // Actualizar una categoría de producto existente
    @PutMapping("/{id}")
    public ResponseEntity<CitasDTO> updateCitas(@PathVariable Integer id, @RequestBody CitasDTO citasDTO) {
        Citas existingCitas = citasService.findById(id);
        if (existingCitas != null) {
            Citas citas = citasMapper.toEntity(citasDTO);
            citas.setIdCita(id); // Asegura que se actualice la categoría correcta
            Citas updatedCitas = citasService.save(citas);
            CitasDTO updatedCitasDTO = citasMapper.toDto(updatedCitas);
            return new ResponseEntity<>(updatedCitasDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar una categoría de producto por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCitas(@PathVariable Integer id) {
        Citas existingCitas = citasService.findById(id);
        if (existingCitas != null) {
            citasService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
