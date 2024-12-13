package com.huellitasChalacas.VeterinariaIntegrador.model;

import jakarta.persistence.*;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)  // Esto llamará al equals y hashCode de Persona
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Veterinario extends Persona {

    @Column(name = "CMVP")
    private String cmvp;

    //CAMPOS RELACIONADOS
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_especialidad", nullable = false)
    private Especialidad especialidad;
    
    @OneToMany(mappedBy = "veterinario", cascade = CascadeType.ALL)
    private List<Citas> citas;

}
