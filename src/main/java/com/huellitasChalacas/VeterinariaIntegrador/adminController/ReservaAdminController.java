/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.adminController;

import com.huellitasChalacas.VeterinariaIntegrador.dto.ReservaDTO;
import com.huellitasChalacas.VeterinariaIntegrador.mapper.ReservaMapper;
import com.huellitasChalacas.VeterinariaIntegrador.model.Reserva;
import com.huellitasChalacas.VeterinariaIntegrador.service.ReservaService;
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
@RequestMapping("/api/v1/admin/reserva")
public class ReservaAdminController {

    @Autowired
    private ReservaService reservaService;

    @Autowired
    private ReservaMapper reservaMapper;

    // Obtener todas las categorías de productos
    @GetMapping
    public ResponseEntity<List<ReservaDTO>> getAllCategoriasProducto() {
        List<Reserva> reservas = reservaService.listarReservas();
        List<ReservaDTO> reservaDTOs = reservaMapper.toDtoList(reservas);
        return new ResponseEntity<>(reservaDTOs, HttpStatus.OK);
    }

    // Obtener una categoría de producto por ID
    @GetMapping("/{id}")
    public ResponseEntity<ReservaDTO> getReservaById(@PathVariable Integer id) {
        Reserva reserva = reservaService.obtenerReservaPorId(id);
        if (reserva != null) {
            ReservaDTO reservaDTO = reservaMapper.toDto(reserva);
            return new ResponseEntity<>(reservaDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Crear una nueva categoría de producto
    @PostMapping
    public ResponseEntity<ReservaDTO> createReserva(@RequestBody ReservaDTO reservaDTO) {
        Reserva reserva = reservaMapper.toEntity(reservaDTO);
        Reserva newReserva = reservaService.guardarReserva(reserva);
        ReservaDTO newReservaDTO = reservaMapper.toDto(newReserva);
        return new ResponseEntity<>(newReservaDTO, HttpStatus.CREATED);
    }

    // Actualizar una categoría de producto existente
    @PutMapping("/{id}")
    public ResponseEntity<ReservaDTO> updateReserva(@PathVariable Integer id, @RequestBody ReservaDTO reservaDTO) {
        Reserva existingReserva = reservaService.obtenerReservaPorId(id);
        if (existingReserva != null) {
            Reserva reserva = reservaMapper.toEntity(reservaDTO);
            reserva.setIdReserva(id); // Asegura que se actualice la categoría correcta
            Reserva updatedReserva = reservaService.guardarReserva(reserva);
            ReservaDTO updatedReservaDTO = reservaMapper.toDto(updatedReserva);
            return new ResponseEntity<>(updatedReservaDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar una categoría de producto por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReserva(@PathVariable Integer id) {
        Reserva existingReserva = reservaService.obtenerReservaPorId(id);
        if (existingReserva != null) {
            reservaService.eliminarReserva(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
