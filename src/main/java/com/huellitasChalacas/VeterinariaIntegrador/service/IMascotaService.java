/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.service;

import com.huellitasChalacas.VeterinariaIntegrador.model.Mascota;
import java.util.List;

/**
 *
 * @author jtorr
 */
public interface IMascotaService {

    List<Mascota> findAll();

    Mascota findById(Integer id);

    Mascota save(Mascota mascota);

    void deleteById(Integer id);
}
