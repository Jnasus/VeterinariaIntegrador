/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.service;

import com.huellitasChalacas.VeterinariaIntegrador.model.Raza;
import java.util.List;

/**
 *
 * @author jtorr
 */
public interface IRazaService {

    List<Raza> findAll();

    Raza findById(Integer id);

    Raza save(Raza raza);

    void deleteById(Integer id);
}
