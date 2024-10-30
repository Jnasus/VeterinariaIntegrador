/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.service;

import com.huellitasChalacas.VeterinariaIntegrador.model.AntecedentesPersonales;
import com.huellitasChalacas.VeterinariaIntegrador.repository.AntecedentesPersonalesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jtorr
 */
@Service
public class AntecedentesPersonalesService implements IAntecedentesPersonalesService {

    @Autowired
    private AntecedentesPersonalesRepository antecedentesPersonalesRepository;

    @Override
    public List<AntecedentesPersonales> findAll() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return antecedentesPersonalesRepository.findAll();
    }

    @Override
    public AntecedentesPersonales findById(Integer id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return antecedentesPersonalesRepository.findById(id).orElse(null);
    }

    @Override
    public AntecedentesPersonales save(AntecedentesPersonales antecedentesPersonales) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return antecedentesPersonalesRepository.save(antecedentesPersonales);
    }

    @Override
    public void deleteById(Integer id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        antecedentesPersonalesRepository.deleteById(id);
    }

}
