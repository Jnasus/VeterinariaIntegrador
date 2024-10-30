/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.service;

import com.huellitasChalacas.VeterinariaIntegrador.model.Especies;
import com.huellitasChalacas.VeterinariaIntegrador.repository.EspeciesRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jtorr
 */
@Service
public class EspeciesService implements IEspeciesService{
     @Autowired
    private EspeciesRepository especiesRepository;

    @Override
    public Especies crearEspecie(Especies especie) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return especiesRepository.save(especie);
    }

    @Override
    public Especies actualizarEspecie(Especies especie) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return especiesRepository.save(especie);
    }

    @Override
    public List<Especies> listarTodasLasEspecies() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return especiesRepository.findAll();
    }


    @Override
    public Especies obtenerEspeciePorId(Integer id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Optional<Especies> especie = especiesRepository.findById(id);
        return especie.orElse(null);
    }

    @Override
    public void eliminarEspecie(Integer id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        especiesRepository.deleteById(id);
    }
}
