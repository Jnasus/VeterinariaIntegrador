package com.huellitasChalacas.VeterinariaIntegrador.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "antecedentes_personales")
public class AntecedentesPersonales {

    @Id
    @Column(name = "id_antecedente", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAntecedente;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "descripcion")
    private String descripcion;

    //CAMPOS RELACIONADOS
    @ManyToOne
    @JoinColumn(name = "id_historia", nullable = false)
    private Historia historia;

}
