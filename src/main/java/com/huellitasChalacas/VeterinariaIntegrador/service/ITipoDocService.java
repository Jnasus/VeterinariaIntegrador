/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.service;

import com.huellitasChalacas.VeterinariaIntegrador.model.TipoDoc;
import java.util.List;

/**
 *
 * @author jtorr
 */
public interface ITipoDocService {

    List<TipoDoc> findAll();

    TipoDoc findById(Integer id);

    TipoDoc save(TipoDoc tipoDoc);

    void deleteById(Integer id);
}
