package pe.edu.upeu.proyInt.service;

import pe.edu.upeu.proyInt.entity.CursoSemestreEntity;

import java.util.List;

public interface CursoSemestreService {
    List<CursoSemestreEntity> cursoSemestreListar();
    CursoSemestreEntity guardarCursoSemestre(CursoSemestreEntity cursoSemestreEntity);
    CursoSemestreEntity editarCursoSemestre(int id, CursoSemestreEntity cursoSemestreEntity);
    void eliminarCursoSemestre(int id);
}
