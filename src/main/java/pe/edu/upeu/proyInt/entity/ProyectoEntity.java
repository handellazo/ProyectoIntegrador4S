package pe.edu.upeu.proyInt.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "PROYECTO")
public class ProyectoEntity implements Serializable {
    private static final long serialVersionUID = -2170897015344177815L;

    @Id
    @Column(name = "ID_PROYECTO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqProyecto")
    @SequenceGenerator(sequenceName = "SEQ_PROYECTO", allocationSize = 1, name = "seqProyecto")
    private Integer id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "INICIO")
    private Date inicio;

    @Column(name = "FIN")
    private Date fin;

    @Column(name = "ANEXO")
    private Integer anexo;
}
