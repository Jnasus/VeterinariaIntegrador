/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.mapper;

import com.huellitasChalacas.VeterinariaIntegrador.dto.UsuarioDTO;
import com.huellitasChalacas.VeterinariaIntegrador.model.Usuario;
import java.util.List;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 *
 * @author jtorr
 */
@Mapper(componentModel = "spring", uses = {RoleMapper.class})
public interface UsuarioMapper {

    @Mapping(source = "persona.idPersona", target = "idPersona")
    @Mapping(target = "roleIds", ignore = true)
    UsuarioDTO toDto(Usuario usuario);

    @Mapping(source = "idPersona", target = "persona.idPersona") // Asumiendo que `Persona` tiene `idPersona`
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "idUsuario", ignore = true)
    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "authorities", ignore = true)
    Usuario toEntity(UsuarioDTO usuarioDTO);

    @IterableMapping(elementTargetType = UsuarioDTO.class)
    List<UsuarioDTO> toDtoList(List<Usuario> usuarios);
}
