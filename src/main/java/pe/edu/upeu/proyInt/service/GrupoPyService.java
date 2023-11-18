package pe.edu.upeu.proyInt.service;

import pe.edu.upeu.proyInt.dto.GrupoPyDto;
import pe.edu.upeu.proyInt.entity.EpEntity;
import pe.edu.upeu.proyInt.entity.GrupoPyEntity;

import java.util.List;

public interface GrupoPyService {
    List<GrupoPyEntity> grupoPyListar();
    GrupoPyEntity buscarGrupoPyPorId(int id);
    GrupoPyEntity guardarGrupoPy(GrupoPyDto grupoPyDto);
    GrupoPyEntity editarGrupoPy(int id, GrupoPyDto grupoPyDto);
    void eliminarGrupoPy(int id);
}
