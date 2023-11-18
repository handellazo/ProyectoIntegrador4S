package pe.edu.upeu.proyInt.service;

import pe.edu.upeu.proyInt.dto.MatriculaDto;
import pe.edu.upeu.proyInt.entity.EpEntity;
import pe.edu.upeu.proyInt.entity.MatriculaEntity;

import java.util.List;

public interface MatriculaService {
    List<MatriculaEntity> matriculaListar();
    MatriculaEntity buscarMatriculaPorId(int id);
    MatriculaEntity guardarMatricula(MatriculaDto matriculaDto);
    MatriculaEntity editarMatricula(int id, MatriculaDto matriculaDto);
    void eliminarMatricula(int id);
}
