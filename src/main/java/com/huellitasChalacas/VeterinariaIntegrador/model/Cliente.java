package com.huellitasChalacas.VeterinariaIntegrador.model;

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
@Table(name = "cliente")
public class Cliente extends Persona {

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Mascota> mascotas;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<FacturaMaestro> facturasMaestro;

}
