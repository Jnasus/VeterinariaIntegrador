/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.service;

import com.huellitasChalacas.VeterinariaIntegrador.model.Especialidad;
import java.util.List;

/**
 *
 * @author jtorr
 */
public interface IEspecialidadService {

    List<Especialidad> findAll();

    Especialidad findById(Integer id);

    Especialidad save(Especialidad especialidad);

    void deleteById(Integer id);
}
