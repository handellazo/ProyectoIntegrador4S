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

    @Column(name = "ANEXO")
    private String anexo;

    @Column(name = "ESTADO")
    private String estado;

    @Column(name = "CANT_BENEFICIARIOS")
    private Integer beneficiarios;

    @Column(name = "PRESUPUESTO")
    private Integer presupuesto;

    @Column(name = "URL_DOC")
    private String url_doc;

    @Column(name = "REPRESENTANTE")
    private String representante;

    @ManyToOne
    @JoinColumn(name = "CONVENIO_ID_CONVENIO")
    private ConvenioEntity convenio;

    @ManyToOne
    @JoinColumn(name = "UBICACION_ID_UBICACION")
    private UbicacionEntity ubicacion;

    @ManyToOne
    @JoinColumn(name = "EP_ID_EP")
    private EpEntity ep;

    @ManyToOne
    @JoinColumn(name = "TIPOPY_ID_TIPOPY")
    private TipoPYEntity tipoPY;

    @ManyToOne
    @JoinColumn(name = "SEMESTRE_ID_SEMESTRE")
    private SemestreEntity semestre;


}
