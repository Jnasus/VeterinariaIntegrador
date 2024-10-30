/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.service;

import com.huellitasChalacas.VeterinariaIntegrador.model.Tratamiento;
import java.util.List;

/**
 *
 * @author jtorr
 */
public interface ITratamientoService {

    List<Tratamiento> findAll();

    Tratamiento findById(Integer id);

    Tratamiento save(Tratamiento tratamiento);

    void deleteById(Integer id);
}
