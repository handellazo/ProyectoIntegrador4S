package pe.edu.upeu.proyInt.service;

import pe.edu.upeu.proyInt.dto.CursoDto;
import pe.edu.upeu.proyInt.entity.CursoEntity;

import java.util.List;

public interface CursoService {
    List<CursoEntity> cursoListar();
    CursoEntity buscarCursoPorId(int id);
    CursoEntity guardarCurso(CursoDto cursoDto);
    CursoEntity editarCurso(int id, CursoDto cursoDto);
    void eliminarCurso(int id);
}
