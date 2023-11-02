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
@Table(name = "MATRICULA")
public class MatriculaEntity implements Serializable {
    private static final long serialVersionUID = -2170897015344177815L;

    @Id
    @Column(name = "ID_MATRICULA")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqMatricula")
    @SequenceGenerator(sequenceName = "SEQ_MATRICULA", allocationSize = 1, name = "seqMatricula")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "ESTUDIANTE_ID_ESTUDIANTE")
    private CursoEntity estudiante;

    @ManyToOne
    @JoinColumn(name = "CURSOSEMESTRE_ID_CURSOSEMESTRE")
    private SemestreEntity curso;

    @Column(name = "CICLO")
    private Integer ciclo;

}
