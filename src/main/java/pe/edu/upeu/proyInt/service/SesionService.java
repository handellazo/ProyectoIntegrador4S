package pe.edu.upeu.proyInt.service;

import pe.edu.upeu.proyInt.entity.SesionEntity;

import java.util.List;

public interface SesionService {
    List<SesionEntity> sesionListar();
    SesionEntity guardarSesion(SesionEntity sesionEntity);
    SesionEntity editarSesion(int id, SesionEntity sesionEntity);
    void eliminarSesion(int id);
}
