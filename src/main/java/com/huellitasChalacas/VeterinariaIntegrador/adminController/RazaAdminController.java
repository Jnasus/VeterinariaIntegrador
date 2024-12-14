/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.adminController;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.huellitasChalacas.VeterinariaIntegrador.dto.RazaDTO;
import com.huellitasChalacas.VeterinariaIntegrador.model.Raza;
import com.huellitasChalacas.VeterinariaIntegrador.mapper.RazaMapper;
import com.huellitasChalacas.VeterinariaIntegrador.service.RazaService;

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
@RequestMapping("/api/v1/admin/raza")
public class RazaAdminController {

    @Autowired
    private RazaService razaService;

    @Autowired
    private RazaMapper razaMapper;

    // Obtener todas las razas
    @GetMapping
    public ResponseEntity<List<RazaDTO>> getAllRazas() {
        List<Raza> razas = razaService.findAll();
        List<RazaDTO> razaDTOs = razaMapper.toDtoList(razas);
        return new ResponseEntity<>(razaDTOs, HttpStatus.OK);
    }

    // Obtener una raza por ID
    @GetMapping("/{id}")
    public ResponseEntity<RazaDTO> getRazaById(@PathVariable Integer id) {
        Raza raza = razaService.findById(id);
        if (raza != null) {
            RazaDTO razaDTO = razaMapper.toDTO(raza);
            return new ResponseEntity<>(razaDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Crear una nueva raza
    @PostMapping
    public ResponseEntity<RazaDTO> createRaza(@RequestBody RazaDTO razaDTO) {
        Raza raza = razaMapper.toEntity(razaDTO);
        Raza newRaza = razaService.save(raza);
        RazaDTO newRazaDTO = razaMapper.toDTO(newRaza);
        return new ResponseEntity<>(newRazaDTO, HttpStatus.CREATED);
    }

    // Actualizar una raza existente
    @PutMapping("/{id}")
    public ResponseEntity<RazaDTO> updateRaza(@PathVariable Integer id, @RequestBody RazaDTO razaDTO) {
        Raza existingRaza = razaService.findById(id);
        if (existingRaza != null) {
            Raza raza = razaMapper.toEntity(razaDTO);
            raza.setIdRaza(id); // Asegura que se actualice la raza correcta
            Raza updatedRaza = razaService.save(raza);
            RazaDTO updatedRazaDTO = razaMapper.toDTO(updatedRaza);
            return new ResponseEntity<>(updatedRazaDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar una raza por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRaza(@PathVariable Integer id) {
        Raza existingRaza = razaService.findById(id);
        if (existingRaza != null) {
            razaService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
