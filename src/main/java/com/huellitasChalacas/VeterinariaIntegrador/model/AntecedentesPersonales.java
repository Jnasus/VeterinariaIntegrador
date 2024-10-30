package com.huellitasChalacas.VeterinariaIntegrador.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "antecedentes_personales")
public class AntecedentesPersonales {

    @Id
    @Column(name = "id_antecedente", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAntecedente;

//    @Column(name = "id_historia")
//    private Integer idHistoria;
    
    @ManyToOne
    @JoinColumn(name = "id_historia", nullable = false)
    private Historia historia;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "descripcion")
    private String descripcion;

}
