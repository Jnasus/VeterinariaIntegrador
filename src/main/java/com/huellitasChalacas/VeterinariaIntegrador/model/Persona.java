package com.huellitasChalacas.VeterinariaIntegrador.model;

//import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Persona {

    @Id
    @Column(name = "id_persona", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPersona;

    @Column
    private String nombres;

    @Column
    private String aPaterno;

    @Column
    private String aMaterno;

    @Column
    private String sexo;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column
    private LocalDate fechNacimiento;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "celular")
    private String celular;

    @Column(name = "correo")
    private String correo;

    //CAMPOS DE AUDITORIA
    @Column(columnDefinition = "TIMESTAMP(3)", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @Column(columnDefinition = "TIMESTAMP(3)")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    @Column(name = "doc_ID")
    private String docId;

    //CAMPOS RELACIONADOS
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipoDoc", nullable = false)
    private TipoDoc tipoDoc;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
    private List<Usuario> usuarios;

}
