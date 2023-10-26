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
@Table(name = "FACULTAD")
public class FacultadEntity implements Serializable {
    private static final long serialVersionUID = -2170897015344177815L;

    @Id
    @Column(name = "ID_FACULTAD")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqFacultad")
    @SequenceGenerator(sequenceName = "SEQ_FACULTAD", allocationSize = 1, name = "seqFacultad")
    private Integer id;

    @Column(name = "FACULTAD")
    private String facultad;

}
