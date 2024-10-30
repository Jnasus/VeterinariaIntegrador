/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.service;

import com.huellitasChalacas.VeterinariaIntegrador.model.ExamenFisico;
import com.huellitasChalacas.VeterinariaIntegrador.repository.ExamenFisicoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jtorr
 */
@Service
public class ExamenFisicoService implements IExamenFisicoService {

    @Autowired
    private ExamenFisicoRepository examenFisicoRepository;

    @Override
    public List<ExamenFisico> findAll() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return examenFisicoRepository.findAll();
    }

    @Override
    public ExamenFisico findById(Integer id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return examenFisicoRepository.findById(id).orElse(null);
    }

    @Override
    public ExamenFisico save(ExamenFisico examenFisico) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return examenFisicoRepository.save(examenFisico);
    }

    @Override
    public void deleteById(Integer id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        examenFisicoRepository.deleteById(id);
    }
}
