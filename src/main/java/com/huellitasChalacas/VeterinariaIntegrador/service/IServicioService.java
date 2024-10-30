/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.service;

import com.huellitasChalacas.VeterinariaIntegrador.model.Servicio;
import java.util.List;

/**
 *
 * @author jtorr
 */
public interface IServicioService {

    List<Servicio> findAll();

    Servicio findById(Integer id);

    Servicio save(Servicio servicio);

    void deleteById(Integer id);
}
