package pe.edu.upeu.proyInt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.upeu.proyInt.entity.CursoSemestreEntity;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProyectoDto {

    private String nombre;

    private Date inicio;

    private Date fin;

    private String anexo;

    private String estado;

    private Integer beneficiarios;

    private Integer presupuesto;

    private String url_doc;

    private String representante;

    private String convenio;

    private String ubicacion;

    private String ep;

    private String tipoPY;

    private String semestre;

    private String cursoSemestre;
}
