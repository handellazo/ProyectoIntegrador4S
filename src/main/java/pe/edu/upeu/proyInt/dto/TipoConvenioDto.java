package pe.edu.upeu.proyInt.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TipoConvenioDto {

    private Integer id;

    private String nombre;

}
