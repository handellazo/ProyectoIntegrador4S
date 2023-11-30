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

    private Integer estado;

    private Integer beneficiarios;

    private Integer presupuesto;

    private String url_doc;

    private String representante;

    private Integer convenio; //FK

    private Integer ubicacion; //FK

    private Integer ep; //FK

    private Integer tipoPY; //FK

    private Integer semestre; //FK

    private Integer cursoSemestre; //FK
}