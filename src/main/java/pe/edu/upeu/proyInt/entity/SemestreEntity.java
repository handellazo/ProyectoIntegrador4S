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
@Table(name = "SEMESTRE")
public class SemestreEntity implements Serializable {
    private static final long serialVersionUID = -2170897015344177815L;

    @Id
    @Column(name = "ID_SEMESTRE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqSemestre")
    @SequenceGenerator(sequenceName = "SEQ_SEMESTRE", allocationSize = 1, name = "seqSemestre")
    private Integer id;

    @Column(name = "SEMESTRE")
    private String semestre;

}
