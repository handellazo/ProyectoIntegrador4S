package pe.edu.upeu.proyInt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProyectoDto {

    private String nombre;

    private Date inicio;

    private Date fin;

    private String tipo;

    private String anexo;

    private Integer beneficiarios;

    private String facultad;

    private String ep;

    private Integer presupuesto;

    private Integer convenio;

    private Integer curso;

    private Integer ubicacion;
}
