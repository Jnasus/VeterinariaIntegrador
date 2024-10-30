/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.service;

import com.huellitasChalacas.VeterinariaIntegrador.model.FacturaDetalle;
import com.huellitasChalacas.VeterinariaIntegrador.repository.FacturaDetalleRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jtorr
 */
@Service
public class FacturaDetalleService implements IFacturaDetalleService {
    @Autowired
    private FacturaDetalleRepository facturaDetalleRepository;

    @Override
    public FacturaDetalle crearFacturaDetalle(FacturaDetalle facturaDetalle) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return facturaDetalleRepository.save(facturaDetalle);
    }

    @Override
    public FacturaDetalle actualizarFacturaDetalle(FacturaDetalle facturaDetalle) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return facturaDetalleRepository.save(facturaDetalle);
    }

    @Override
    public FacturaDetalle obtenerFacturaDetallePorId(Integer id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Optional<FacturaDetalle> facturaDetalle = facturaDetalleRepository.findById(id);
        return facturaDetalle.orElse(null);
    }

    @Override
    public List<FacturaDetalle> listarTodosLosDetallesDeFactura() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return facturaDetalleRepository.findAll();
    }

    @Override
    public void eliminarFacturaDetalle(Integer id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        facturaDetalleRepository.deleteById(id);
    }
    
    
    
}
