/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.adminController;

import com.huellitasChalacas.VeterinariaIntegrador.dto.ServicioDTO;
import com.huellitasChalacas.VeterinariaIntegrador.mapper.ServicioMapper;
import com.huellitasChalacas.VeterinariaIntegrador.model.Servicio;
import com.huellitasChalacas.VeterinariaIntegrador.service.ServicioService;
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
@RequestMapping("/ap1/v1/admin/servicio")
public class ServicioAdminController {

    @Autowired
    private ServicioService servicioService;

    @Autowired
    private ServicioMapper servicioMapper;

    // Obtener todas las categorías de productos
    @GetMapping
    public ResponseEntity<List<ServicioDTO>> getAllCategoriasProducto() {
        List<Servicio> servicios = servicioService.findAll();
        List<ServicioDTO> servicioDTOs = servicioMapper.toDtoList(servicios);
        return new ResponseEntity<>(servicioDTOs, HttpStatus.OK);
    }

    // Obtener una categoría de producto por ID
    @GetMapping("/{id}")
    public ResponseEntity<ServicioDTO> getServicioById(@PathVariable Integer id) {
        Servicio servicio = servicioService.findById(id);
        if (servicio != null) {
            ServicioDTO servicioDTO = servicioMapper.toDto(servicio);
            return new ResponseEntity<>(servicioDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Crear una nueva categoría de producto
    @PostMapping
    public ResponseEntity<ServicioDTO> createServicio(@RequestBody ServicioDTO servicioDTO) {
        Servicio servicio = servicioMapper.toEntity(servicioDTO);
        Servicio newServicio = servicioService.save(servicio);
        ServicioDTO newServicioDTO = servicioMapper.toDto(newServicio);
        return new ResponseEntity<>(newServicioDTO, HttpStatus.CREATED);
    }

    // Actualizar una categoría de producto existente
    @PutMapping("/{id}")
    public ResponseEntity<ServicioDTO> updateServicio(@PathVariable Integer id, @RequestBody ServicioDTO servicioDTO) {
        Servicio existingServicio = servicioService.findById(id);
        if (existingServicio != null) {
            Servicio servicio = servicioMapper.toEntity(servicioDTO);
            servicio.setIdArticulo(id); // Asegura que se actualice la categoría correcta
            Servicio updatedServicio = servicioService.save(servicio);
            ServicioDTO updatedServicioDTO = servicioMapper.toDto(updatedServicio);
            return new ResponseEntity<>(updatedServicioDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar una categoría de producto por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServicio(@PathVariable Integer id) {
        Servicio existingServicio = servicioService.findById(id);
        if (existingServicio != null) {
            servicioService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
