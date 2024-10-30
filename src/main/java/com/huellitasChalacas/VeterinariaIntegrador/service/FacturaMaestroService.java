/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.service;

import com.huellitasChalacas.VeterinariaIntegrador.model.FacturaMaestro;
import com.huellitasChalacas.VeterinariaIntegrador.repository.FacturaMaestroRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jtorr
 */
@Service
public class FacturaMaestroService implements IFacturaMaestroService {

    @Autowired
    private FacturaMaestroRepository facturaMaestroRepository;

    @Override
    public FacturaMaestro crearFacturaMaestro(FacturaMaestro facturaMaestro) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return facturaMaestroRepository.save(facturaMaestro);
    }

    @Override
    public FacturaMaestro actualizarFacturaMaestro(FacturaMaestro facturaMaestro) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return facturaMaestroRepository.save(facturaMaestro);
    }

    @Override
    public FacturaMaestro obtenerFacturaMaestroPorId(Integer id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Optional<FacturaMaestro> facturaMaestro = facturaMaestroRepository.findById(id);
        return facturaMaestro.orElse(null);
    }

    @Override
    public List<FacturaMaestro> listarTodasLasFacturas() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return facturaMaestroRepository.findAll();
    }

    @Override
    public void eliminarFacturaMaestro(Integer id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        facturaMaestroRepository.deleteById(id);
    }

}
