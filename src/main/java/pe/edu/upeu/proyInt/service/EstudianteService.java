package pe.edu.upeu.proyInt.service;

import pe.edu.upeu.proyInt.entity.EstudianteEntity;

import java.util.List;

public interface EstudianteService {
    List<EstudianteEntity> estudianteListar();
    EstudianteEntity guardarEstudiante(EstudianteEntity estudianteEntity);
    EstudianteEntity editarEstudiante(int id, EstudianteEntity estudianteEntity);
    void eliminarEstudiante(int id);
}
