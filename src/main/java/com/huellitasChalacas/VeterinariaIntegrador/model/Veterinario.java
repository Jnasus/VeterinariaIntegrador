package com.huellitasChalacas.VeterinariaIntegrador.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)  // Esto llamará al equals y hashCode de Persona
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "veterinario")
public class Veterinario extends Persona {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_especialidad", nullable = false)
    //@JsonBackReference //evita la serializacion infinita
    private Especialidad especialidad;

    @Column(name = "CMVP")
    private String cmvp;
    
    //@OneToMany
    @OneToMany(mappedBy = "veterinario", cascade = CascadeType.ALL)
    //@JsonManagedReference // mantiene la referencia en serializacion
    private List<Citas> citas;

}
