/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.service;

import com.huellitasChalacas.VeterinariaIntegrador.model.Articulo;
import com.huellitasChalacas.VeterinariaIntegrador.repository.ArticulosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jtorr
 */
@Service
public class ArticuloService implements IArticuloService {
    @Autowired
    private ArticulosRepository articulosRepository;

    @Override
    public List<Articulo> findAll() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return articulosRepository.findAll();
    }

    @Override
    public Articulo findById(Integer id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return articulosRepository.findById(id).orElse(null);
    }

    @Override
    public Articulo save(Articulo articulo) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return articulosRepository.save(articulo);
    }

    @Override
    public void deleteById(Integer id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        articulosRepository.deleteById(id);
    }
    
    
}
