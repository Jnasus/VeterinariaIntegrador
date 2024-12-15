package com.huellitasChalacas.VeterinariaIntegrador.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.huellitasChalacas.VeterinariaIntegrador.util.LocalTimeDeserializer;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "citas")
public class Citas {

    @Id
    @Column(name = "id_cita", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCita;

    @Column(name = "fecha")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate fecha;

    @Column(name = "hora")
    @JsonDeserialize(using = LocalTimeDeserializer.class)  // Aquí se agrega el deserializador personalizado
    private LocalTime hora;

    @Column(name = "estado", nullable = false)
    private String estado;

    @Column(name = "observaciones")
    private String observaciones;

    //CAMPOS RELACIONADOS
    @ManyToOne
    @JoinColumn(name = "id_veterinario", nullable = false)
    private Veterinario veterinario;

    // Relación con Reserva
    @OneToMany(mappedBy = "cita")
    private List<Reserva> reservas;

}
