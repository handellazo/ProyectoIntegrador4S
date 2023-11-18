package pe.edu.upeu.proyInt.service;

import pe.edu.upeu.proyInt.dto.RolDto;
import pe.edu.upeu.proyInt.entity.RolEntity;

import java.util.List;

public interface RolService {
    List<RolEntity> rolListar();
    RolEntity buscarRolPorId(int id);
    RolEntity guardarRol(RolDto rolDto);
    RolEntity editarRol(int id, RolDto rolDto);
    void eliminarRol(int id);
}
