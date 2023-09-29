package pe.edu.upeu.proyInt.service;

import pe.edu.upeu.proyInt.entity.UbicacionEntity;

import java.util.List;

public interface UbicacionService {
    List<UbicacionEntity> ubicacionListar();
    UbicacionEntity buscarUbicacionPorID(int id);
    UbicacionEntity buscarUbicacionPorDep(String departamento);
    UbicacionEntity buscarUbicacionPorProv(String provincia);
    List<UbicacionEntity> depListar();
    UbicacionEntity guardarUbicacion(UbicacionEntity ubicacionEntity);
    UbicacionEntity editarUbicacion(int id, UbicacionEntity ubicacionEntity);
    void eliminarUbicacion(int id);
}
