/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.service;

import com.huellitasChalacas.VeterinariaIntegrador.model.Veterinario;
import com.huellitasChalacas.VeterinariaIntegrador.repository.VeterinarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jtorr
 */
@Service
public class VeterinarioService implements IVeterinarioService {

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    @Override
    public List<Veterinario> findAll() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return veterinarioRepository.findAll();
    }

    @Override
    public Veterinario findById(Integer id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return veterinarioRepository.findById(id).orElse(null);
    }

    @Override
    public Veterinario save(Veterinario veterinario) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return veterinarioRepository.save(veterinario);
    }

    @Override
    public void deleteById(Integer id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        veterinarioRepository.deleteById(id);
    }

}
