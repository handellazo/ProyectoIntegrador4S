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
@Table(name = "CURSOSEMESTRE")
public class CursoSemestreEntity implements Serializable {
    private static final long serialVersionUID = -2170897015344177815L;

    @Id
    @Column(name = "ID_CURSO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCursoSemestre")
    @SequenceGenerator(sequenceName = "SEQ_CURSOSEMESTRE", allocationSize = 1, name = "seqCursoSemestre")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "CURSO_ID_CURSO")
    private CursoEntity curso;

    @ManyToOne
    @JoinColumn(name = "SEMESTRE_ID_SEMESTRE")
    private SemestreEntity semestre;

    @ManyToOne
    @JoinColumn(name = "DOCENTE_ID_DOCENTE")
    private DocenteEntity docente;

    @ManyToOne
    @JoinColumn(name = "EP_ID_EP")
    private EpEntity ep;

}
