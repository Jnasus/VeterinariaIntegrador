/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.service;

import com.huellitasChalacas.VeterinariaIntegrador.model.Especies;
import java.util.List;

/**
 *
 * @author jtorr
 */
public interface IEspeciesService {

    Especies crearEspecie(Especies especie);

    Especies actualizarEspecie(Especies especie);

    Especies obtenerEspeciePorId(Integer id);

    List<Especies> listarTodasLasEspecies();

    void eliminarEspecie(Integer id);
}
