/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.service;

import com.huellitasChalacas.VeterinariaIntegrador.model.FacturaDetalle;
import java.util.List;

/**
 *
 * @author jtorr
 */
public interface IFacturaDetalleService {
    FacturaDetalle crearFacturaDetalle(FacturaDetalle facturaDetalle);
    FacturaDetalle actualizarFacturaDetalle(FacturaDetalle facturaDetalle);
    FacturaDetalle obtenerFacturaDetallePorId(Integer id);
    List<FacturaDetalle> listarTodosLosDetallesDeFactura();
    void eliminarFacturaDetalle(Integer id);
    
}
