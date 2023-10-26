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
@Table(name = "ROLDOC")
public class RolDocEntity implements Serializable {
    private static final long serialVersionUID = -2170897015344177815L;

    @Id
    @Column(name = "ID_ROLDOC")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqRolDoc")
    @SequenceGenerator(sequenceName = "SEQ_ROLDOC", allocationSize = 1, name = "seqRolDoc")
    private Integer id;

    @Column(name="ROLDOC")
    private String rol;

    @Column(name="DESCRIPCION")
    private String descripcion;
}
