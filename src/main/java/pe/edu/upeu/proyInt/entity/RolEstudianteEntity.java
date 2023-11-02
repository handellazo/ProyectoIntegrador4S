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
@Table(name = "ROLEST")
public class RolEstudianteEntity implements Serializable {
    private static final long serialVersionUID = -2170897015344177815L;

    @Id
    @Column(name = "ID_ROLEST")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqRolEst")
    @SequenceGenerator(sequenceName = "SEQ_ROLEST", allocationSize = 1, name = "seqRolEst")
    private Integer id;

    @Column(name="NOMBRE")
    private String nombre;

}
