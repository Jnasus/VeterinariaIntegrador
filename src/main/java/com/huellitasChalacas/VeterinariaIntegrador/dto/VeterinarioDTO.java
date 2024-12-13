/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.dto;

import java.io.Serializable;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author jtorr
 */
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class VeterinarioDTO implements Serializable {

    private Integer idPersona;
    private String nombres;
    private String aPaterno;
    private String aMaterno;
    private String sexo;
    private LocalDate fechNacimiento;
    private String direccion;
    private String celular;
    private String correo;
    private String docId;
    private String cmvp;
    //DTOS ANIDADOS
    private TipoDocDTO tipoDocDTO; // Para almacenar el nombre del tipo de documento
    private EspecialidadDTO especialidadDTO;

}
