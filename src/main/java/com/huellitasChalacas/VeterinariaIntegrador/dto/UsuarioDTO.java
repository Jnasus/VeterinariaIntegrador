/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.dto;

import java.io.Serializable;
import java.util.Set;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author jtorr
 */
@Getter
@Setter
@EqualsAndHashCode
public class UsuarioDTO implements Serializable {
//    private String username;
//    private String password;
//    private PersonaDTO personaDTO;
//    //private RoleDTO roleDTO;

    private String username;
    private String password;
    private Integer idPersona; // Asumiendo que necesitas asociar una Persona
    private Set<Integer> roleIds; // IDs de los roles a asignar
    // Agrega otros campos necesarios, como nombre, etc.
}
