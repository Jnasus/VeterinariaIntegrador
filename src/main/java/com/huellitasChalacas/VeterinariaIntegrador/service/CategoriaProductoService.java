/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.service;

import com.huellitasChalacas.VeterinariaIntegrador.model.CategoriaProducto;
import com.huellitasChalacas.VeterinariaIntegrador.repository.CategoriaProductoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jtorr
 */
@Service
public class CategoriaProductoService implements ICategoriaProductoService {

    @Autowired
    private CategoriaProductoRepository categoriaProductoRepository;

    @Override
    public CategoriaProducto crearCategoriaProducto(CategoriaProducto categoriaProducto) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return categoriaProductoRepository.save(categoriaProducto);
    }

    @Override
    public CategoriaProducto actualizarCategoriaProducto(CategoriaProducto categoriaProducto) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return categoriaProductoRepository.save(categoriaProducto);
    }

    @Override
    public CategoriaProducto obtenerCategoriaProductoPorId(Integer id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Optional<CategoriaProducto> categoriaProducto = categoriaProductoRepository.findById(id);
        return categoriaProducto.orElse(null);
    }

    @Override
    public List<CategoriaProducto> listarTodasLasCategoriasProducto() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return categoriaProductoRepository.findAll();
    }

    @Override
    public void eliminarCategoriaProducto(Integer id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        categoriaProductoRepository.deleteById(id);
    }
}
