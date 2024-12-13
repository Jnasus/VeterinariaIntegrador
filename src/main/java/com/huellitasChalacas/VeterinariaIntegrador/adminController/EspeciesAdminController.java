/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.adminController;

import com.huellitasChalacas.VeterinariaIntegrador.service.EspeciesService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import com.huellitasChalacas.VeterinariaIntegrador.dto.EspeciesDTO;
import com.huellitasChalacas.VeterinariaIntegrador.model.Especies;
import com.huellitasChalacas.VeterinariaIntegrador.mapper.EspeciesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author jtorr
 */
@RestController
@RequestMapping("/api/v1/admin/especies")
public class EspeciesAdminController {
    
    @Autowired
    private EspeciesService especiesService;

    @Autowired
    private EspeciesMapper especiesMapper;

    // Obtener todas las especies
    @GetMapping
    public ResponseEntity<List<EspeciesDTO>> getAllEspecies() {
        List<Especies> especies = especiesService.listarTodasLasEspecies();
        List<EspeciesDTO> especiesDTOs = especiesMapper.toDtoList(especies);
        return new ResponseEntity<>(especiesDTOs, HttpStatus.OK);
    }

    // Obtener una especie por ID
    @GetMapping("/{id}")
    public ResponseEntity<EspeciesDTO> getEspecieById(@PathVariable Integer id) {
        Especies especie = especiesService.obtenerEspeciePorId(id);
        if (especie != null) {
            EspeciesDTO especieDTO = especiesMapper.toDTO(especie);
            return new ResponseEntity<>(especieDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Crear una nueva especie
    @PostMapping
    public ResponseEntity<EspeciesDTO> createEspecie(@RequestBody EspeciesDTO especiesDTO) {
        Especies especie = especiesMapper.toEntity(especiesDTO);
        Especies newEspecie = especiesService.crearEspecie(especie);
        EspeciesDTO newEspecieDTO = especiesMapper.toDTO(newEspecie);
        return new ResponseEntity<>(newEspecieDTO, HttpStatus.CREATED);
    }

    // Actualizar una especie existente
    @PutMapping("/{id}")
    public ResponseEntity<EspeciesDTO> updateEspecie(@PathVariable Integer id, @RequestBody EspeciesDTO especiesDTO) {
        Especies existingEspecie = especiesService.obtenerEspeciePorId(id);
        if (existingEspecie != null) {
            Especies especie = especiesMapper.toEntity(especiesDTO);
            especie.setIdEspecie(id); // Asegura que se actualice la especie correcta
            Especies updatedEspecie = especiesService.actualizarEspecie(especie);
            EspeciesDTO updatedEspecieDTO = especiesMapper.toDTO(updatedEspecie);
            return new ResponseEntity<>(updatedEspecieDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar una especie por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEspecie(@PathVariable Integer id) {
        Especies existingEspecie = especiesService.obtenerEspeciePorId(id);
        if (existingEspecie != null) {
            especiesService.eliminarEspecie(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
}
