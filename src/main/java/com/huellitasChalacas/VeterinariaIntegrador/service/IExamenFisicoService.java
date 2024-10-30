/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.service;

import com.huellitasChalacas.VeterinariaIntegrador.model.ExamenFisico;
import java.util.List;

/**
 *
 * @author jtorr
 */
public interface IExamenFisicoService {

    List<ExamenFisico> findAll();

    ExamenFisico findById(Integer id);

    ExamenFisico save(ExamenFisico examenFisico);

    void deleteById(Integer id);
}
