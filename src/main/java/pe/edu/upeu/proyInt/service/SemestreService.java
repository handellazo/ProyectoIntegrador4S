package pe.edu.upeu.proyInt.service;

import pe.edu.upeu.proyInt.entity.SemestreEntity;

import java.util.List;

public interface SemestreService {
    List<SemestreEntity> semestreListar();
    SemestreEntity guardarSemestre(SemestreEntity semestreEntity);
    SemestreEntity editarSemestre(int id, SemestreEntity semestreEntity);
    void eliminarSemestre(int id);
}
