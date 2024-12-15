/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.service;

import com.huellitasChalacas.VeterinariaIntegrador.dto.UsuarioDTO;
import com.huellitasChalacas.VeterinariaIntegrador.mapper.UsuarioMapper;
import com.huellitasChalacas.VeterinariaIntegrador.model.Persona;
import com.huellitasChalacas.VeterinariaIntegrador.model.Role;
import com.huellitasChalacas.VeterinariaIntegrador.model.Usuario;
import com.huellitasChalacas.VeterinariaIntegrador.repository.PersonaRepository;
import com.huellitasChalacas.VeterinariaIntegrador.repository.RoleRepository;
import com.huellitasChalacas.VeterinariaIntegrador.repository.UsuarioRepository;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author jtorr
 */
@Slf4j
@Service
public class UsuarioService implements IUsuarioService, UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UsuarioMapper usuarioMapper;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PersonaRepository personaRepository;


    @Override
    public List<Usuario> findAll() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario findById(Integer id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));
    }

    @Override
    public Usuario save(Usuario usuario) {
        // Encriptamos la contraseña antes de guardar el usuario
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioRepository.save(usuario);
    }

    @Override
    public void deleteById(Integer id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        usuarioRepository.deleteById(id);
    }

    @Override
    public Usuario findByUsername(String username) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return usuarioRepository.findByUsername(username).orElse(null);
    }

    // Métodos de UserDetailsService (para la autenticación con Spring Security)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Buscamos al usuario por su nombre de usuario
        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con el nombre: " + username));

        // Devolvemos directamente la entidad Usuario que ya implementa UserDetails
        return usuario;
    }
    
    // Método para crear un nuevo usuario con roles asignados
    public Usuario crearUsuario(UsuarioDTO usuarioDTO) {
        // Mapear DTO a entidad Usuario
        Usuario usuario = usuarioMapper.toEntity(usuarioDTO);

        // Buscar la persona asociada
        Persona persona = personaRepository.findById(usuarioDTO.getIdPersona())
                .orElseThrow(() -> new RuntimeException("Persona no encontrada con ID: " + usuarioDTO.getIdPersona()));
        usuario.setPersona(persona);

        // Asignar roles
        Set<Role> roles = new HashSet<>();
        if (usuarioDTO.getRoleIds() == null || usuarioDTO.getRoleIds().isEmpty()) {
            // Asignar ROLE_USER por defecto
            Role userRole = roleRepository.findByNombre("ROLE_USER")
                    .orElseThrow(() -> new RuntimeException("Role no encontrado: ROLE_USER"));
            roles.add(userRole);
        } else {
            // Asignar roles según los IDs proporcionados
            roles = usuarioDTO.getRoleIds().stream()
                    .map(idRol -> roleRepository.findById(idRol)
                            .orElseThrow(() -> new RuntimeException("Role no encontrado con ID: " + idRol)))
                    .collect(Collectors.toSet());
        }
        usuario.setRoles(roles);

        // Guardar el usuario
        return save(usuario);
    }

}
