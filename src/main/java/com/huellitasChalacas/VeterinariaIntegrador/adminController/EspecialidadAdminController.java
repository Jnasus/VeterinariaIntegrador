/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.adminController;

import com.huellitasChalacas.VeterinariaIntegrador.dto.EspecialidadDTO;
import com.huellitasChalacas.VeterinariaIntegrador.mapper.EspecialidadMapper;
import com.huellitasChalacas.VeterinariaIntegrador.model.Especialidad;
import com.huellitasChalacas.VeterinariaIntegrador.service.EspecialidadService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author jtorr
 */
@RestController
@RequestMapping("/api/v1/admin/controller")
public class EspecialidadAdminController {
    
    
     @Autowired
    private EspecialidadService especialidadService;

    @Autowired
    private EspecialidadMapper especialidadMapper;

    // Obtener todas las especialidads
    @GetMapping
    public ResponseEntity<List<EspecialidadDTO>> getAllEspecialidads() {
        List<Especialidad> especialidads = especialidadService.findAll();
        List<EspecialidadDTO> especialidadDTOs = especialidadMapper.toDtoList(especialidads);
        return new ResponseEntity<>(especialidadDTOs, HttpStatus.OK);
    }

    // Obtener una especialidad por ID
    @GetMapping("/{id}")
    public ResponseEntity<EspecialidadDTO> getEspecialidadById(@PathVariable Integer id) {
        Especialidad especialidad = especialidadService.findById(id);
        if (especialidad != null) {
            EspecialidadDTO especialidadDTO = especialidadMapper.toDTO(especialidad);
            return new ResponseEntity<>(especialidadDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Crear una nueva especialidad
    @PostMapping
    public ResponseEntity<EspecialidadDTO> createEspecialidad(@RequestBody EspecialidadDTO especialidadDTO) {
        Especialidad especialidad = especialidadMapper.toEntity(especialidadDTO);
        Especialidad newEspecialidad = especialidadService.save(especialidad);
        EspecialidadDTO newEspecialidadDTO = especialidadMapper.toDTO(newEspecialidad);
        return new ResponseEntity<>(newEspecialidadDTO, HttpStatus.CREATED);
    }

    // Actualizar una especialidad existente
    @PutMapping("/{id}")
    public ResponseEntity<EspecialidadDTO> updateEspecialidad(@PathVariable Integer id, @RequestBody EspecialidadDTO especialidadDTO) {
        Especialidad existingEspecialidad = especialidadService.findById(id);
        if (existingEspecialidad != null) {
            Especialidad especialidad = especialidadMapper.toEntity(especialidadDTO);
            especialidad.setIdEspecialidad(id); // Asegura que se actualice la especialidad correcta
            Especialidad updatedEspecialidad = especialidadService.save(especialidad);
            EspecialidadDTO updatedEspecialidadDTO = especialidadMapper.toDTO(updatedEspecialidad);
            return new ResponseEntity<>(updatedEspecialidadDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar una especialidad por ID
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
