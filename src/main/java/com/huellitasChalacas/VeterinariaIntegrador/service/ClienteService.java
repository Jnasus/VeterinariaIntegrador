/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.service;

import com.huellitasChalacas.VeterinariaIntegrador.dto.ClienteDTO;
import com.huellitasChalacas.VeterinariaIntegrador.model.Cliente;
import com.huellitasChalacas.VeterinariaIntegrador.repository.ClienteRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jtorr
 */
@Service
public class ClienteService implements IClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<ClienteDTO> findAll() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream().map(this::convertirAClienteDTO).collect(Collectors.toList());
    }

    @Override
    public Cliente findById(Integer id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public Cliente save(Cliente cliente) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return clienteRepository.save(cliente);
    }

    @Override
    public void deleteById(Integer id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        clienteRepository.deleteById(id);
    }

    // Método para convertir Cliente a ClienteDTO
    public ClienteDTO convertirAClienteDTO(Cliente cliente) {
        String nombreTipoDoc = cliente.getTipoDoc() != null ? cliente.getTipoDoc().getNombre() : null;

        return new ClienteDTO(
                cliente.getIdPersona(),
                cliente.getNombres(),
                cliente.getAPaterno(),
                cliente.getAMaterno(),
                cliente.getSexo(),
                cliente.getFechNacimiento(),
                cliente.getDireccion(),
                cliente.getCelular(),
                cliente.getCorreo(),
                cliente.getDocId(),
                nombreTipoDoc
        );
    }

    @Override
    public List<ClienteDTO> searchClientesByName(String nombre) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        List<Cliente> clientes = clienteRepository.findByNombresContainingIgnoreCase(nombre);
        return clientes.stream().map(this::convertirAClienteDTO).collect(Collectors.toList());
    }

}
