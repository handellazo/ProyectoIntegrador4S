package pe.edu.upeu.proyInt.service;

import pe.edu.upeu.proyInt.dto.EstadoProyDto;
import pe.edu.upeu.proyInt.entity.EstadoProyEntity;

import java.util.List;

public interface EstadoProyService {
    List<EstadoProyEntity> estadoProyListar();
    EstadoProyEntity buscarEstadoProyPorId(int id);
    EstadoProyEntity guardarEstadoProy(EstadoProyDto cursoDto);
    EstadoProyEntity editarEstadoProy(int id, EstadoProyDto cursoDto);
    void eliminarEstadoProy(int id);
}
