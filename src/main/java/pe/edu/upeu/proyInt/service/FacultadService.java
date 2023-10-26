package pe.edu.upeu.proyInt.service;

import pe.edu.upeu.proyInt.entity.FacultadEntity;

import java.util.List;

public interface FacultadService {
    List<FacultadEntity> facultadListar();
    FacultadEntity guardarFacultad(FacultadEntity facultadEntity);
    FacultadEntity editarFacultad(int id, FacultadEntity facultadEntity);
    void eliminarFacultad(int id);
}
