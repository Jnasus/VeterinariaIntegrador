/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.service;

import com.huellitasChalacas.VeterinariaIntegrador.model.Citas;
import java.util.List;

/**
 *
 * @author jtorr
 */
public interface ICitasService {

    List<Citas> findAll();

    Citas findById(Integer id);

    Citas save(Citas citas);

    void deleteById(Integer id);
}
