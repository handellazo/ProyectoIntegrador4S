package pe.edu.upeu.proyInt.service;

import pe.edu.upeu.proyInt.entity.EpEntity;

import java.util.List;

public interface EpService {
    List<EpEntity> epListar();
    EpEntity guardarEp(EpEntity epEntity);
    EpEntity editarEp(int id, EpEntity epEntity);
    void eliminarEp(int id);
}
