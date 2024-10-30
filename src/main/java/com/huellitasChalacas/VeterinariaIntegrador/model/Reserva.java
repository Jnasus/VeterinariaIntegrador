package com.huellitasChalacas.VeterinariaIntegrador.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reserva")
public class Reserva {

    @Id
    @Column(name = "id_reserva", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReserva;

//    @Column(name = "id_cita")
//    private Integer idCita;
    @ManyToOne
    @JoinColumn(name = "id_cita")
    private Citas cita;

    @ManyToOne
    @JoinColumn(name = "id_mascota", nullable = false)
    private Mascota mascota;

    @Column(name = "fecha_reserva")
    private Date fechaReserva;

//    @Column(name = "id_servicio")
//    private Integer idServicio;
    
    @ManyToOne
    @JoinColumn(name = "id_servicio")
    private Servicio servicio;

    @Column(name = "estado", nullable = false)
    private String estado;

}
