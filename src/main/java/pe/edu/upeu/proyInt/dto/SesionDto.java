package pe.edu.upeu.proyInt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.upeu.proyInt.entity.ProyectoEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SesionDto {

    private Integer id;

    private String fecha;

    private Integer proyecto; //FK
}
