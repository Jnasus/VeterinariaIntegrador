package com.huellitasChalacas.VeterinariaIntegrador.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "examen_fisico")
public class ExamenFisico {

    @Id
    @Column(name = "id_examen", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idExamen;

//    @Column(name = "id_historia")
//    private Integer idHistoria;
    
    @ManyToOne
    @JoinColumn(name = "id_historia", nullable = false)
    private Historia historia;

    @Column(name = "signos_vitales")
    private String signosVitales;

    @Column(name = "exploracion_sistemas")
    private String exploracionSistemas;

    @Column(name = "resultados_examenes")
    private String resultadosExamenes;

}
