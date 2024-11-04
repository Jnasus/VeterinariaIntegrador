/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author jtorr
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO implements Serializable {
    private Integer idPersona;
    private String nombres;
    private String aPaterno;
    private String aMaterno;
    private String sexo;
    private Date fechNacimiento;
    private String direccion;
    private String celular;
    private String correo;
    private String docId;
    private String nombreTipoDoc; // Para almacenar el nombre del tipo de documento
}
