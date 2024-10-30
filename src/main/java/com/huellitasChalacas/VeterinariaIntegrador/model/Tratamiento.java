package com.huellitasChalacas.VeterinariaIntegrador.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tratamiento")
public class Tratamiento {

    @Id
    @Column(name = "id_tratamiento", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTratamiento;

//    @Column(name = "id_historia")
//    private Integer idHistoria;
    @ManyToOne
    @JoinColumn(name = "id_historia", nullable = false)
    private Historia historia;

    @Column(name = "medicamentos")
    private String medicamentos;

    @Column(name = "procedimientos")
    private String procedimientos;

    @Column(name = "evolucion")
    private String evolucion;

}
