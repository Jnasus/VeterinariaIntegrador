/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.service;

import java.util.List;
import com.huellitasChalacas.VeterinariaIntegrador.model.Role;

/**
 *
 * @author jtorr
 */
public interface IRoleService {

    List<Role> findAll();

    Role findById(Integer id);

    Role save(Role rol);

    void deleteById(Integer id);
    
    Role findByNombre(String nombre);

}
