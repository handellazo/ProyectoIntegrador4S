package pe.edu.upeu.proyInt.service;

import pe.edu.upeu.proyInt.entity.GrupoPyEntity;

import java.util.List;

public interface GrupoPyService {
    List<GrupoPyEntity> grupoPyListar();
    GrupoPyEntity guardarGrupoPy(GrupoPyEntity grupoPyEntity);
    GrupoPyEntity editarGrupoPy(int id, GrupoPyEntity grupoPyEntity);
    void eliminarGrupoPy(int id);
}
