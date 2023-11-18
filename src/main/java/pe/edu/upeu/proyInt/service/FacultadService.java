package pe.edu.upeu.proyInt.service;

import pe.edu.upeu.proyInt.dto.FacultadDto;
import pe.edu.upeu.proyInt.entity.EpEntity;
import pe.edu.upeu.proyInt.entity.FacultadEntity;

import java.util.List;

public interface FacultadService {
    List<FacultadEntity> facultadListar();
    FacultadEntity buscarFacultadPorId(int id);
    FacultadEntity guardarFacultad(FacultadDto facultadDto);
    FacultadEntity editarFacultad(int id, FacultadDto facultadDto);
    void eliminarFacultad(int id);
}
