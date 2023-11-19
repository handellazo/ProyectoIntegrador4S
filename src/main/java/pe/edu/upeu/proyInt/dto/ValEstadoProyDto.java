package pe.edu.upeu.proyInt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ValEstadoProyDto {
    private Integer id;

    private Integer proyecto; //FK

    private Integer estadoProy; //FK

    private String estado;

    private String codigo;
}
