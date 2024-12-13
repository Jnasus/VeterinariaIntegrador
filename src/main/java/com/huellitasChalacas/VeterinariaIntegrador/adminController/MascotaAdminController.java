/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.adminController;

import com.huellitasChalacas.VeterinariaIntegrador.dto.MascotaDTO;
import com.huellitasChalacas.VeterinariaIntegrador.mapper.MascotaMapper;
import com.huellitasChalacas.VeterinariaIntegrador.model.Mascota;
import com.huellitasChalacas.VeterinariaIntegrador.service.MascotaService;
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
@RequestMapping("/api/v1/admin/mascota")
public class MascotaAdminController {

    @Autowired
    private MascotaService mascotaService;

    @Autowired
    private MascotaMapper mascotaMapper;

    // Obtener todas las mascotas
    @GetMapping
    public ResponseEntity<List<MascotaDTO>> getAllMascotas() {
        List<Mascota> mascotas = mascotaService.findAll();
        List<MascotaDTO> mascotaDTOs = mascotaMapper.toDtoList(mascotas);
        return new ResponseEntity<>(mascotaDTOs, HttpStatus.OK);
    }

    // Obtener una mascota por ID
    @GetMapping("/{id}")
    public ResponseEntity<MascotaDTO> getMascotaById(@PathVariable Integer id) {
        Mascota mascota = mascotaService.findById(id);
        if (mascota != null) {
            MascotaDTO mascotaDTO = mascotaMapper.toDTO(mascota);
            return new ResponseEntity<>(mascotaDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Crear una nueva mascota
    @PostMapping
    public ResponseEntity<MascotaDTO> createMascota(@RequestBody MascotaDTO mascotaDTO) {
        Mascota mascota = mascotaMapper.toEntity(mascotaDTO);
        Mascota newMascota = mascotaService.save(mascota);
        MascotaDTO newMascotaDTO = mascotaMapper.toDTO(newMascota);
        return new ResponseEntity<>(newMascotaDTO, HttpStatus.CREATED);
    }

    // Actualizar una mascota existente
    @PutMapping("/{id}")
    public ResponseEntity<MascotaDTO> updateMascota(@PathVariable Integer id, @RequestBody MascotaDTO mascotaDTO) {
        Mascota existingMascota = mascotaService.findById(id);
        if (existingMascota != null) {
            Mascota mascota = mascotaMapper.toEntity(mascotaDTO);
            mascota.setIdMascota(id); // Asegura que se actualice la mascota correcta
            Mascota updatedMascota = mascotaService.save(mascota);
            MascotaDTO updatedMascotaDTO = mascotaMapper.toDTO(updatedMascota);
            return new ResponseEntity<>(updatedMascotaDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar una mascota por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMascota(@PathVariable Integer id) {
        Mascota existingMascota = mascotaService.findById(id);
        if (existingMascota != null) {
            mascotaService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
