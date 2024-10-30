package com.huellitasChalacas.VeterinariaIntegrador.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "citas")
public class Citas {

    @Id
    @Column(name = "id_cita", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCita;

//    @Column(name = "id_veterinario")
//    private Integer idVeterinario;
    
    @ManyToOne
    @JoinColumn(name = "id_veterinario")
    @JsonBackReference //evita la serializacion infinita
    private Veterinario veterinario;
    
     // Relación con Reserva
    @OneToMany(mappedBy = "cita")
    private List<Reserva> reservas;

    //@Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    //@Column(name = "hora")
    @Temporal(TemporalType.TIME)
    private Time hora;

    @Column(name = "estado", nullable = false)
    private String estado;

    @Column(name = "observaciones")
    private String observaciones;

}
