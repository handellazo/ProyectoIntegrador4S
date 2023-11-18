package pe.edu.upeu.proyInt.service;

import pe.edu.upeu.proyInt.dto.SemestreDto;
import pe.edu.upeu.proyInt.entity.ProyectoEntity;
import pe.edu.upeu.proyInt.entity.SemestreEntity;

import java.util.List;

public interface SemestreService {
    List<SemestreEntity> semestreListar();
    SemestreEntity buscarSemestrePorId(int id);
    SemestreEntity guardarSemestre(SemestreDto semestreDto);
    SemestreEntity editarSemestre(int id, SemestreDto semestreDto);
    void eliminarSemestre(int id);
}
