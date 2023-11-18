package pe.edu.upeu.proyInt.service;

import pe.edu.upeu.proyInt.dto.EstudianteDto;
import pe.edu.upeu.proyInt.entity.EpEntity;
import pe.edu.upeu.proyInt.entity.EstudianteEntity;

import java.util.List;

public interface EstudianteService {
    List<EstudianteEntity> estudianteListar();
    EstudianteEntity buscarEstudiantePorId(int id);
    EstudianteEntity guardarEstudiante(EstudianteDto estudianteDto);
    EstudianteEntity editarEstudiante(int id, EstudianteDto estudianteDto);
    void eliminarEstudiante(int id);
}
