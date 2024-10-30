/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.service;

import com.huellitasChalacas.VeterinariaIntegrador.model.Cliente;
import java.util.List;

/**
 *
 * @author jtorr
 */
public interface IClienteService {
    List<Cliente> findAll();
    Cliente findById(Integer id);
    Cliente save(Cliente cliente);
    void deleteById(Integer id);
}
