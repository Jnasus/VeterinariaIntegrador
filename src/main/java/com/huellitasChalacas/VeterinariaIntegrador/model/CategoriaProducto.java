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
@Table(name = "categoria_producto")
public class CategoriaProducto {

    @Id
    @Column(name = "id_categoria", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCategoria;

    @Column(name = "nombre", nullable = false)
    private String nombre;
    
    @OneToMany(mappedBy = "categoria")
    @JsonManagedReference // Mantiene la referencia en serialización
    private List<Producto> productos;

}
