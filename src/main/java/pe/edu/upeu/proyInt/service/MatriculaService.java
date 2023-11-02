package pe.edu.upeu.proyInt.service;

import pe.edu.upeu.proyInt.entity.MatriculaEntity;

import java.util.List;

public interface MatriculaService {
    List<MatriculaEntity> matriculaListar();
    MatriculaEntity guardarMatricula(MatriculaEntity matriculaEntity);
    MatriculaEntity editarMatricula(int id, MatriculaEntity matriculaEntity);
    void eliminarMatricula(int id);
}
