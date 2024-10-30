/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.service;

import java.util.List;
import com.huellitasChalacas.VeterinariaIntegrador.model.Roles;

/**
 *
 * @author jtorr
 */
public interface IRolesService {

    List<Roles> findAll();

    Roles findById(Integer id);

    Roles save(Roles rol);

    void deleteById(Integer id);

}
