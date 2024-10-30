/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.service;

import com.huellitasChalacas.VeterinariaIntegrador.model.Persona;
import java.util.List;

/**
 *
 * @author jtorr
 */
public interface IPersonaServicio {
    
    List<Persona> findAll();
    Persona findById(Integer id);
    Persona save(Persona persona);
    void deleteById(Integer id);
    
}
