/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.service;

import com.huellitasChalacas.VeterinariaIntegrador.model.Articulo;
import java.util.List;

/**
 *
 * @author jtorr
 */
public interface IArticuloService {

    List<Articulo> findAll();

    Articulo findById(Integer id);

    Articulo save(Articulo articulo);

    void deleteById(Integer id);
}
