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
@RestController
@RequestMapping("/api/v1/admin/cliente")
public class ClienteAdminController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteMapper clienteMapper;

    @Autowired
    private TipoDocMapper tipoDocMapper;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> getAllClientes() {
        List<Cliente> clientes = clienteService.findAll();
        List<ClienteDTO> clienteDTOs = clienteMapper.toDtoList(clientes); // Usa el nuevo método
        return new ResponseEntity<>(clienteDTOs, HttpStatus.OK);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<ClienteDTO>> searchClientes(@RequestParam String nombre) {
        List<Cliente> clientes = clienteService.searchClientesByName(nombre);
        List<ClienteDTO> clienteDTOs = clienteMapper.toDtoList(clientes); // Usa el nuevo método
        return new ResponseEntity<>(clienteDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> getClienteById(@PathVariable Integer id) {
        Cliente cliente = clienteService.findById(id);
        if (cliente != null) {
            ClienteDTO clienteDTO = clienteMapper.toDTO(cliente); // Mapeo de entidad a DTO
            return new ResponseEntity<>(clienteDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> createCliente(@RequestBody ClienteDTO clienteDTO) {
        Cliente cliente = clienteMapper.toEntity(clienteDTO); // Mapeo de DTO a entidad
        Cliente newCliente = clienteService.save(cliente);
        ClienteDTO newClienteDTO = clienteMapper.toDTO(newCliente); // Mapeo de entidad a DTO
        return new ResponseEntity<>(newClienteDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> updateCliente(@PathVariable Integer id, @RequestBody ClienteDTO clienteDTO) {
        Cliente existingCliente = clienteService.findById(id);
        if (existingCliente != null) {
            clienteDTO.setIdPersona(id); // Asegura que se actualice la entidad correcta
            Cliente cliente = clienteMapper.toEntity(clienteDTO); // Mapeo de DTO a entidad
            Cliente updatedCliente = clienteService.save(cliente);
            ClienteDTO updatedClienteDTO = clienteMapper.toDTO(updatedCliente); // Mapeo de entidad a DTO
            return new ResponseEntity<>(updatedClienteDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Integer id) {
        Cliente existingCliente = clienteService.findById(id);
        if (existingCliente != null) {
            clienteService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
