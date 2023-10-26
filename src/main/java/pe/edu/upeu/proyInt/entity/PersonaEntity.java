package pe.edu.upeu.proyInt.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "PERSONA")
public class PersonaEntity implements Serializable {
    private static final long serialVersionUID = -2170897015344177815L;

    @Id
    @Column(name = "ID_PERSONA")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPersona")
    @SequenceGenerator(sequenceName = "SEQ_PERSONA", allocationSize = 1, name = "seqPersona")
    private Integer id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "APELLIDO_PAT")
    private String paterno;

    @Column(name = "APELLIDO_MAT")
    private String materno;

    @Column(name = "DNI")
    private Integer dni;

    @Column(name = "CORREO")
    private String correo;

    @Column(name = "TELF")
    private Integer telefono;

    @Column(name = "CONTRASEÑA")
    private String contraseña;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ROL_ID_ROL")
    private RolEntity rol;
}
