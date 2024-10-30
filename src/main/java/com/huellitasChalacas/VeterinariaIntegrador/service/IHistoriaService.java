/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.service;

import com.huellitasChalacas.VeterinariaIntegrador.model.Historia;
import java.util.List;

/**
 *
 * @author jtorr
 */
public interface IHistoriaService {

    List<Historia> findAll();

    Historia findById(Integer id);

    Historia save(Historia historia);

    void deleteById(Integer id);
}
