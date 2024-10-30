package com.huellitasChalacas.VeterinariaIntegrador.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "historia")
public class Historia {

    @Id
    @Column(name = "id_historia", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idHistoria;
    
    @OneToOne
    @JoinColumn(name = "id_mascota", nullable = false)
    private Mascota mascota;

    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    @Column(name = "motivo_consulta")
    private String motivoConsulta;
    
    @OneToMany(mappedBy = "historia")
    private List<Diagnostico> diagnosticos;

    @OneToMany(mappedBy = "historia")
    private List<Tratamiento> tratamientos;
    
    @OneToMany(mappedBy = "historia")
    private List<AntecedentesPersonales> antecedentes;
    
     @OneToMany(mappedBy = "historia")
    private List<ExamenFisico> examenFisicos;    

}
