/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.service;

import com.huellitasChalacas.VeterinariaIntegrador.model.Diagnostico;
import java.util.List;

/**
 *
 * @author jtorr
 */
public interface IDiagnosticoService {

    List<Diagnostico> findAll();

    Diagnostico findById(Integer id);

    Diagnostico save(Diagnostico diagnostico);

    void deleteById(Integer id);
}
