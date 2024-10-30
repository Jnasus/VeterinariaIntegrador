/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.service;

import com.huellitasChalacas.VeterinariaIntegrador.model.FacturaMaestro;
import java.util.List;

/**
 *
 * @author jtorr
 */
public interface IFacturaMaestroService {
    FacturaMaestro crearFacturaMaestro(FacturaMaestro facturaMaestro);
    FacturaMaestro actualizarFacturaMaestro(FacturaMaestro facturaMaestro);
    FacturaMaestro obtenerFacturaMaestroPorId(Integer id);
    List<FacturaMaestro> listarTodasLasFacturas();
    void eliminarFacturaMaestro(Integer id);
}
