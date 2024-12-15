/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.mapper;

import com.huellitasChalacas.VeterinariaIntegrador.dto.PersonaDTO;
import com.huellitasChalacas.VeterinariaIntegrador.model.Persona;
import java.util.List;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 *
 * @author jtorr
 */
@Mapper(componentModel = "spring")
public interface PersonaMapper {

    PersonaDTO toDto(Persona persona);

    @Mapping(target = "usuarios", ignore = true)
    @Mapping(target = "sexo", ignore = true)
    @Mapping(target = "fechNacimiento", ignore = true)
    @Mapping(target = "direccion", ignore = true)
    @Mapping(target = "celular", ignore = true)
    @Mapping(target = "correo", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "tipoDoc", ignore = true)
    Persona toEntity(PersonaDTO personaDTO);

    @IterableMapping(elementTargetType = PersonaDTO.class)
    List<PersonaDTO> toDtoList(List<Persona> personas);

}
