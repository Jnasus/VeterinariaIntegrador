/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.service;

import com.huellitasChalacas.VeterinariaIntegrador.model.Reserva;
import java.util.List;

/**
 *
 * @author jtorr
 */
public interface IReservaService {

    List<Reserva> listarReservas();

    Reserva obtenerReservaPorId(Integer id);

    Reserva guardarReserva(Reserva reserva);

    void eliminarReserva(Integer id);
}
