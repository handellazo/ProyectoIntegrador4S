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

    @Column(name = "FECHA_INICIO")
    private Date inicio;

    @Column(name = "FECHA_FIN")
    private Date fin;

    @Column(name = "TIPO")
    private String tipo;

    @Column(name = "ANEXO")
    private String anexo;

    @Column(name = "CANT_BENEFICIARIOS")
    private Integer beneficiarios;

    @Column(name = "FACULTAD")
    private String facultad;

    @Column(name = "ESCUELA_PROFESIONAL")
    private String ep;

    @Column(name = "PRESUPUESTO")
    private Integer presupuesto;

    @ManyToOne
    @JoinColumn(name = "CONVENIO_ID_CONVENIO")
    private ConvenioEntity convenio;

    @ManyToOne
    @JoinColumn(name = "CURSO_ID_CURSO")
    private CursoEntity curso;

    @ManyToOne
    @JoinColumn(name = "UBICACION_ID_UBICACION")
    private UbicacionEntity ubicacion;
}
