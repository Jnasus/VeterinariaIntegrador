/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.service;

import com.huellitasChalacas.VeterinariaIntegrador.model.Veterinario;
import java.util.List;

/**
 *
 * @author jtorr
 */
public interface IVeterinarioService {
    List<Veterinario> findAll();
    Veterinario findById(Integer id);
    Veterinario save(Veterinario veterinario);
    void deleteById(Integer id);
    
}
