/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.service;

import com.huellitasChalacas.VeterinariaIntegrador.model.Producto;
import java.util.List;

/**
 *
 * @author jtorr
 */
public interface IProductoService {
    List<Producto> findAll();
    Producto findById(Integer id);
    Producto save(Producto producto);
    void deleteById(Integer id);
}
