/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.service;

import com.huellitasChalacas.VeterinariaIntegrador.model.Usuario;
import java.util.List;

/**
 *
 * @author jtorr
 */
public interface IUsuarioService {

    List<Usuario> findAll();

    Usuario findById(Integer id);

    Usuario save(Usuario usuario);

    void deleteById(Integer id);

    Usuario findByUsername(String username);
}
