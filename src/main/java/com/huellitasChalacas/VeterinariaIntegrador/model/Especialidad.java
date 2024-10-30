package com.huellitasChalacas.VeterinariaIntegrador.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "especialidad")
public class Especialidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Especialidad", nullable = false)
    private Integer idEspecialidad;

    @Column(name = "nombre", nullable = false)
    private String nombre;
    
    @OneToMany(mappedBy = "especialidad", cascade = CascadeType.ALL)
    //@JsonManagedReference // mantiene la referencia en serializacion 
    private List<Veterinario> veterinarios;

}
