package pe.edu.upeu.proyInt.service;

import pe.edu.upeu.proyInt.entity.CursoEntity;

import java.util.List;

public interface CursoService {
    List<CursoEntity> cursoListar();
    CursoEntity buscarCursoPorID(int id);
    CursoEntity guardarCurso(CursoEntity cursoEntity);
    CursoEntity editarCurso(int id, CursoEntity cursoEntity);
    void eliminarCurso(int id);
}
