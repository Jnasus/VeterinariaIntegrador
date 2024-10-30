/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.service;

import com.huellitasChalacas.VeterinariaIntegrador.model.TipoServicio;
import java.util.List;

/**
 *
 * @author jtorr
 */
public interface ITipoServicioService {

    List<TipoServicio> findAll();

    TipoServicio findById(Integer id);

    TipoServicio save(TipoServicio tipoServicio);

    void deleteById(Integer id);
}
