/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.dto;

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
public class MascotaDTO {
    private Integer idMascota;
    private String nombre;
    private String aPaterno;
    private String aMaterno;
    private LocalDate fechNacimiento;
    private String sexo;
    //DTOS ANIDADOS
    private RazaDTO razaDTO;
    private EspeciesDTO especieDTO;
    private ClienteDTO clienteDTO;
}
