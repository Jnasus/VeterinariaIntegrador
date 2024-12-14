/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.mapper;

import com.huellitasChalacas.VeterinariaIntegrador.dto.ReservaDTO;
import com.huellitasChalacas.VeterinariaIntegrador.model.Reserva;
import java.util.List;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 *
 * @author jtorr
 */
@Mapper(componentModel = "spring", uses = {CitasMapper.class, MascotaMapper.class, ServicioMapper.class})
public interface ReservaMapper {

    @Mapping(target = "citasDTO", source = "cita")
    @Mapping(target = "mascotaDTO", source = "mascota")
    @Mapping(target = "servicioDTO", source = "servicio")
    ReservaDTO toDto(Reserva reserva);

    @Mapping(target = "cita", source = "citasDTO")
    @Mapping(target = "mascota", source = "mascotaDTO")
    @Mapping(target = "servicio", source = "servicioDTO")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Reserva toEntity(ReservaDTO reservaDTO);

    @IterableMapping(elementTargetType = ReservaDTO.class)
    List<ReservaDTO> toListDto(List<Reserva> reservas);

}
