package pe.edu.upeu.proyInt.service;

import pe.edu.upeu.proyInt.dto.UbicacionDto;
import pe.edu.upeu.proyInt.entity.UbicacionEntity;

import java.util.List;

public interface UbicacionService {
    List<UbicacionEntity> ubicacionListar();
    UbicacionEntity buscarUbicacionPorId(int id);
    List<UbicacionEntity> findByDepartamento(String departamento);
    List<UbicacionEntity> findByProvincia(String provincia);
    List<UbicacionEntity> depListar();
    UbicacionEntity guardarUbicacion(UbicacionDto ubicacionDto);
    UbicacionEntity editarUbicacion(int id, UbicacionDto ubicacionDto);
    void eliminarUbicacion(int id);
}
