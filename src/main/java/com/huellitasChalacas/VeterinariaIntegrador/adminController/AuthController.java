/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.adminController;

import com.huellitasChalacas.VeterinariaIntegrador.dto.UsuarioDTO;
import com.huellitasChalacas.VeterinariaIntegrador.mapper.UsuarioMapper;
import com.huellitasChalacas.VeterinariaIntegrador.model.Usuario;
import com.huellitasChalacas.VeterinariaIntegrador.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author jtorr
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private UsuarioMapper usuarioMapper;
    
     // Endpoint para registrar un nuevo usuario
    @PostMapping("/register")
    public ResponseEntity<Usuario> registerUser(@RequestBody UsuarioDTO usuarioDTO) {
        try {
            Usuario usuario = usuarioService.crearUsuario(usuarioDTO);
            //UsuarioResponseDTO responseDTO = usuarioMapper.toResponseDTO(usuario);
            return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
        } catch (Exception e) {
            // Manejo de errores más específico puede ser implementado
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
