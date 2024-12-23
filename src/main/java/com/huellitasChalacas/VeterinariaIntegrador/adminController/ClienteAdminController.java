/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.adminController;

import com.huellitasChalacas.VeterinariaIntegrador.dto.ClienteDTO;
import com.huellitasChalacas.VeterinariaIntegrador.mapper.ClienteMapper;
import com.huellitasChalacas.VeterinariaIntegrador.mapper.TipoDocMapper;
import com.huellitasChalacas.VeterinariaIntegrador.model.Cliente;
import com.huellitasChalacas.VeterinariaIntegrador.service.ClienteService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jtorr
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/admin/cliente")
public class ClienteAdminController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteMapper clienteMapper;

     // Obtener todos los Clientes
    @GetMapping
    public ResponseEntity<List<ClienteDTO>> getAllClientes() {
        log.info("Iniciando la búsqueda de todos los clientes.");
        List<Cliente> clientes = clienteService.findAll();
        List<ClienteDTO> clienteDTOs = clienteMapper.toDtoList(clientes); // Usa el nuevo método
        log.info("Se encontraron {} clientes.", clienteDTOs.size());
        return new ResponseEntity<>(clienteDTOs, HttpStatus.OK);
    }

    // Buscar Clientes por nombre
    @GetMapping("/buscar")
    public ResponseEntity<List<ClienteDTO>> searchClientes(@RequestParam String nombre) {
        log.info("Buscando clientes por nombre: {}", nombre);
        List<Cliente> clientes = clienteService.searchClientesByName(nombre);
        List<ClienteDTO> clienteDTOs = clienteMapper.toDtoList(clientes); // Usa el nuevo método
        log.info("Se encontraron {} clientes con el nombre: {}", clienteDTOs.size(), nombre);
        return new ResponseEntity<>(clienteDTOs, HttpStatus.OK);
    }

    // Obtener un Cliente por ID
    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> getClienteById(@PathVariable Integer id) {
        log.info("Buscando cliente con ID: {}", id);
        Cliente cliente = clienteService.findById(id);
        if (cliente != null) {
            ClienteDTO clienteDTO = clienteMapper.toDTO(cliente); // Mapeo de entidad a DTO
            log.info("Cliente con ID: {} encontrado.", id);
            return new ResponseEntity<>(clienteDTO, HttpStatus.OK);
        } else {
            log.warn("Cliente con ID: {} no encontrado.", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Crear un nuevo Cliente
    @PostMapping
    public ResponseEntity<ClienteDTO> createCliente(@RequestBody ClienteDTO clienteDTO) {
        log.info("Iniciando la creación de un nuevo cliente con datos: {}", clienteDTO);
        Cliente cliente = clienteMapper.toEntity(clienteDTO); // Mapeo de DTO a entidad
        Cliente newCliente = clienteService.save(cliente);
        ClienteDTO newClienteDTO = clienteMapper.toDTO(newCliente); // Mapeo de entidad a DTO
        log.info("Cliente creado exitosamente con ID: {}", newClienteDTO.getIdPersona());
        return new ResponseEntity<>(newClienteDTO, HttpStatus.CREATED);
    }

    // Actualizar un Cliente existente
    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> updateCliente(@PathVariable Integer id, @RequestBody ClienteDTO clienteDTO) {
        log.info("Iniciando la actualización del cliente con ID: {}", id);
        Cliente existingCliente = clienteService.findById(id);
        if (existingCliente != null) {
            clienteDTO.setIdPersona(id); // Asegura que se actualice la entidad correcta
            Cliente cliente = clienteMapper.toEntity(clienteDTO); // Mapeo de DTO a entidad
            Cliente updatedCliente = clienteService.save(cliente);
            ClienteDTO updatedClienteDTO = clienteMapper.toDTO(updatedCliente); // Mapeo de entidad a DTO
            log.info("Cliente con ID: {} actualizado exitosamente.", id);
            return new ResponseEntity<>(updatedClienteDTO, HttpStatus.OK);
        } else {
            log.warn("Cliente con ID: {} no encontrado para actualización.", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar un Cliente por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Integer id) {
        log.info("Iniciando la eliminación del cliente con ID: {}", id);
        Cliente existingCliente = clienteService.findById(id);
        if (existingCliente != null) {
            clienteService.deleteById(id);
            log.info("Cliente con ID: {} eliminado exitosamente.", id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            log.warn("Cliente con ID: {} no encontrado para eliminación.", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
