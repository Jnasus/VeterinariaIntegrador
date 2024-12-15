/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.adminController;

import com.huellitasChalacas.VeterinariaIntegrador.dto.VeterinarioDTO;
import com.huellitasChalacas.VeterinariaIntegrador.mapper.VeterinarioMapper;
import com.huellitasChalacas.VeterinariaIntegrador.model.Veterinario;
import com.huellitasChalacas.VeterinariaIntegrador.service.VeterinarioService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@RestController
@RequestMapping("/api/v1/admin/veterinario")
public class VeterinarioAdminController {

    @Autowired
    private VeterinarioService veterinarioService;

    @Autowired
    private VeterinarioMapper veterinarioMapper;

    // Obtener todos los Veterinarios
    @GetMapping
    public ResponseEntity<List<VeterinarioDTO>> getAllVeterinarios() {
        log.info("Iniciando la búsqueda de todos los veterinarios.");
        List<Veterinario> veterinarios = veterinarioService.findAll();
        List<VeterinarioDTO> veterinarioDTOs = veterinarioMapper.toDtoList(veterinarios);
        log.info("Se encontraron {} veterinarios.", veterinarioDTOs.size());
        return new ResponseEntity<>(veterinarioDTOs, HttpStatus.OK);
    }

    // Obtener un Veterinario por ID
    @GetMapping("/{id}")
    public ResponseEntity<VeterinarioDTO> getVeterinarioById(@PathVariable Integer id) {
        log.info("Buscando veterinario con ID: {}", id);
        Veterinario veterinario = veterinarioService.findById(id);
        if (veterinario != null) {
            VeterinarioDTO veterinarioDTO = veterinarioMapper.toDTO(veterinario);
            log.info("Veterinario con ID: {} encontrado.", id);
            return new ResponseEntity<>(veterinarioDTO, HttpStatus.OK);
        } else {
            log.warn("Veterinario con ID: {} no encontrado.", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Crear un nuevo Veterinario
    @PostMapping
    public ResponseEntity<VeterinarioDTO> createVeterinario(@RequestBody VeterinarioDTO veterinarioDTO) {
        log.info("Iniciando la creación de un nuevo veterinario con datos: {}", veterinarioDTO);
        Veterinario veterinario = veterinarioMapper.toEntity(veterinarioDTO);
        Veterinario newVeterinario = veterinarioService.save(veterinario);
        VeterinarioDTO newVeterinarioDTO = veterinarioMapper.toDTO(newVeterinario);
        log.info("Veterinario creado exitosamente con ID: {}", newVeterinarioDTO.getIdPersona());
        return new ResponseEntity<>(newVeterinarioDTO, HttpStatus.CREATED);
    }

    // Actualizar un Veterinario existente
    @PutMapping("/{id}")
    public ResponseEntity<VeterinarioDTO> updateVeterinario(@PathVariable Integer id, @RequestBody VeterinarioDTO veterinarioDTO) {
        log.info("Iniciando la actualización del veterinario con ID: {}", id);
        Veterinario existingVeterinario = veterinarioService.findById(id);
        if (existingVeterinario != null) {
            Veterinario veterinario = veterinarioMapper.toEntity(veterinarioDTO);
            veterinario.setIdPersona(id); // Asegura que se actualice el veterinario correcto
            Veterinario updatedVeterinario = veterinarioService.save(veterinario);
            VeterinarioDTO updatedVeterinarioDTO = veterinarioMapper.toDTO(updatedVeterinario);
            log.info("Veterinario con ID: {} actualizado exitosamente.", id);
            return new ResponseEntity<>(updatedVeterinarioDTO, HttpStatus.OK);
        } else {
            log.warn("Veterinario con ID: {} no encontrado para actualización.", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar un Veterinario por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVeterinario(@PathVariable Integer id) {
        log.info("Iniciando la eliminación del veterinario con ID: {}", id);
        Veterinario existingVeterinario = veterinarioService.findById(id);
        if (existingVeterinario != null) {
            veterinarioService.deleteById(id);
            log.info("Veterinario con ID: {} eliminado exitosamente.", id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            log.warn("Veterinario con ID: {} no encontrado para eliminación.", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
