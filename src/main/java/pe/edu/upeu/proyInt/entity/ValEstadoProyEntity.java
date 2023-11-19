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
@Table(name = "VALESTADOPROY")
public class ValEstadoProyEntity implements Serializable {
    private static final long serialVersionUID = -2170897015344177815L;

    @Id
    @Column(name = "ID_VALESTADOPROY")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqValEstadoProy")
    @SequenceGenerator(sequenceName = "SEQ_VALESTADOPROY", allocationSize = 1, name = "seqValEstadoProy")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "PROYECTO_ID_PROYECTO")
    private ProyectoEntity proyecto;

    @ManyToOne
    @JoinColumn(name = "ESTADOPROY_ID_ESTADOPROY")
    private EstadoProyEntity estadoProy;

    @Column(name = "ESTADO")
    private String estado;

    @Column(name = "CODIGO")
    private String codigo;
}
