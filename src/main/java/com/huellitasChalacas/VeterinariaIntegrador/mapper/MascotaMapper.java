/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.mapper;

import com.huellitasChalacas.VeterinariaIntegrador.dto.MascotaDTO;
import com.huellitasChalacas.VeterinariaIntegrador.model.Mascota;
import java.util.List;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 *
 * @author jtorr
 */
@Mapper(componentModel = "spring", uses = {RazaMapper.class, EspeciesMapper.class,ClienteMapper.class})
public interface MascotaMapper {

    // Mapeo de Mascota a MascotaDTO
    @Mapping(target = "razaDTO", source = "raza")
    @Mapping(target = "especieDTO", source = "especie")
    @Mapping(target = "clienteDTO", source = "cliente")
    MascotaDTO toDTO(Mascota mascota);

    // Mapeo de MascotaDTO  a Mascota
    @Mapping(target = "raza", source = "razaDTO")
    @Mapping(target = "especie", source = "especieDTO")
    @Mapping(target = "cliente", source = "clienteDTO")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    //@Mapping(target = "cliente", ignore = true)
    @Mapping(target = "historia", ignore = true)
    @Mapping(target = "reservas", ignore = true)
    Mascota toEntity(MascotaDTO mascotaDTO);

    // Método para mapear listas de Mascota a listas de MascotaDTO 
    @IterableMapping(elementTargetType = MascotaDTO.class)
    List<MascotaDTO> toDtoList(List<Mascota> mascota);

}
