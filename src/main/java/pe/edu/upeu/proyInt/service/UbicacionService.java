package pe.edu.upeu.proyInt.service;

import pe.edu.upeu.proyInt.entity.UbicacionEntity;

import java.util.List;

public interface UbicacionService {
    List<UbicacionEntity> ubicacionListar();
    UbicacionEntity buscarUbicacionPorID(int id);
    UbicacionEntity guardarUbicacion(UbicacionEntity ubicacionEntity);
    UbicacionEntity editarUbicacion(int id, UbicacionEntity ubicacionEntity);
    void eliminarUbicacion(int id);
}
