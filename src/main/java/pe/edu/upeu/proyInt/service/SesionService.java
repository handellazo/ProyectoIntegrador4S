package pe.edu.upeu.proyInt.service;

import pe.edu.upeu.proyInt.dto.SesionDto;
import pe.edu.upeu.proyInt.entity.ProyectoEntity;
import pe.edu.upeu.proyInt.entity.SesionEntity;

import java.util.List;

public interface SesionService {
    List<SesionEntity> sesionListar();
    SesionEntity buscarSesionPorId(int id);
    SesionEntity guardarSesion(SesionDto sesionDto);
    SesionEntity editarSesion(int id, SesionDto sesionDto);
    void eliminarSesion(int id);
}
