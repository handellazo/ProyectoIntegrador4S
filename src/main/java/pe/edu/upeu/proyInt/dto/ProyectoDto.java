package pe.edu.upeu.proyInt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProyectoDto {

    private Integer id;

    private String nombre;

    private Date inicio;

    private Date fin;

    private String anexo;

    private String ciclo;

    private String estado;

    private Integer beneficiarios;

    private Integer presupuesto;

    private String url_doc;

    private String representante;

    private String convenio; //FK

    private String ubicacion; //FK

    private String ep; //FK

    private String tipoPY; //FK

    private String semestre; //FK

    private String cursoSemestre; //FK
}
