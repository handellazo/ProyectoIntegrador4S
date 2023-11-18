package pe.edu.upeu.proyInt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ConvenioDto {

    private Integer id;

    private String nombre;

    private Date inicio;

    private Date fin;

    private String referencia;

    private Integer tipo; //FK

    private Integer ubicacion; //FK

    private String archivo;

    private String estado;
}
