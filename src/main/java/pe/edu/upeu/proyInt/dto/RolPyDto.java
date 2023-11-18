package pe.edu.upeu.proyInt.dto;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.upeu.proyInt.entity.ProyectoEntity;
import pe.edu.upeu.proyInt.entity.RolEstudianteEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RolPyDto {

    private Integer id;

    private String horas;

    private Integer rolEst; //FK

    private Integer proyecto; //FK
}
