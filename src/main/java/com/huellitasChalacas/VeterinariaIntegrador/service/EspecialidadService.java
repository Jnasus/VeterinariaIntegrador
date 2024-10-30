/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.service;

import com.huellitasChalacas.VeterinariaIntegrador.model.Especialidad;
import com.huellitasChalacas.VeterinariaIntegrador.repository.EspecialidadRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jtorr
 */
@Service
public class EspecialidadService implements IEspecialidadService{
    @Autowired
    private EspecialidadRepository especialidadRepository;

    @Override
    public List<Especialidad> findAll() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return especialidadRepository.findAll();
    }

    @Override
    public Especialidad findById(Integer id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return especialidadRepository.findById(id).orElse(null);
    }

    @Override
    public Especialidad save(Especialidad especialidad) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return especialidadRepository.save(especialidad);
    }

    @Override
    public void deleteById(Integer id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        especialidadRepository.deleteById(id);
    }

}
