package pe.edu.upeu.proyInt.service;

import pe.edu.upeu.proyInt.entity.RolEntity;

import java.util.List;

public interface RolService {
    List<RolEntity> rolListar();
    RolEntity buscarRolPorID(int id);
    RolEntity guardarRol(RolEntity rolEntity);
    RolEntity editarRol(int id, RolEntity rolEntity);
    void eliminarRol(int id);
}
