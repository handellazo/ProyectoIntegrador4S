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
@Table(name = "ESTADOPROY")
public class EstadoProyEntity implements Serializable {
    private static final long serialVersionUID = -2170897015344177815L;

    @Id
    @Column(name = "ID_ESTADOPROY")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqEstadoProy")
    @SequenceGenerator(sequenceName = "SEQ_ESTADOPROY", allocationSize = 1, name = "seqEstadoProy")
    private Integer id;

    @Column(name = "NOMBRE")
    private String nombre;

}
