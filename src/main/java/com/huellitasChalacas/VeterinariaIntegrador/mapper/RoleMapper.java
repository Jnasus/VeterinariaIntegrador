/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.mapper;

import com.huellitasChalacas.VeterinariaIntegrador.dto.RoleDTO;
import com.huellitasChalacas.VeterinariaIntegrador.model.Role;
import java.util.Set;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 *
 * @author jtorr
 */

@Mapper(componentModel = "spring")
public interface RoleMapper {
    
    RoleDTO toDto(Role role);
    
    @Mapping(target = "usuarios", ignore = true)
    Role toEntity(RoleDTO roleDTO);
    
    @IterableMapping(elementTargetType = RoleDTO.class)
    Set<RoleDTO> toDtoList(Set<Role> roles);
}
