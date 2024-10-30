/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.service;

import com.huellitasChalacas.VeterinariaIntegrador.model.CategoriaProducto;
import java.util.List;

/**
 *
 * @author jtorr
 */
public interface ICategoriaProductoService {

    CategoriaProducto crearCategoriaProducto(CategoriaProducto categoriaProducto);

    CategoriaProducto actualizarCategoriaProducto(CategoriaProducto categoriaProducto);

    CategoriaProducto obtenerCategoriaProductoPorId(Integer id);

    List<CategoriaProducto> listarTodasLasCategoriasProducto();

    void eliminarCategoriaProducto(Integer id);
}
