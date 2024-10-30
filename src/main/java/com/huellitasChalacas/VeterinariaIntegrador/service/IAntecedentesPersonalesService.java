/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.service;

import com.huellitasChalacas.VeterinariaIntegrador.model.AntecedentesPersonales;
import java.util.List;

/**
 *
 * @author jtorr
 */
public interface IAntecedentesPersonalesService {

    List<AntecedentesPersonales> findAll();

    AntecedentesPersonales findById(Integer id);

    AntecedentesPersonales save(AntecedentesPersonales antecedentesPersonales);

    void deleteById(Integer id);
}
