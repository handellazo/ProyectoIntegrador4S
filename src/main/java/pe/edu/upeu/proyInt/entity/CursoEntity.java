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
@Table(name = "CURSO")
public class CursoEntity implements Serializable {
    private static final long serialVersionUID = -2170897015344177815L;

    @Id
    @Column(name = "ID_CURSO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCurso")
    @SequenceGenerator(sequenceName = "SEQ_CURSO", allocationSize = 1, name = "seqCurso")
    private Integer id;

    @Column(name = "NOMBRE")
    private String nombre;

}
