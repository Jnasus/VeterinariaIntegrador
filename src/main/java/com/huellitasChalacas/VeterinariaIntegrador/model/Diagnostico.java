package com.huellitasChalacas.VeterinariaIntegrador.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "diagnostico")
public class Diagnostico {

    @Id
    @Column(name = "id_diagnostico", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDiagnostico;

//    @Column(name = "id_historia")
//    private Integer idHistoria;
    
    @ManyToOne
    @JoinColumn(name = "id_historia", nullable = false)
    private Historia historia;
    

    @Column(name = "enfermedad")
    private String enfermedad;

    @Column(name = "diagnostico_diferencial")
    private String diagnosticoDiferencial;

}
