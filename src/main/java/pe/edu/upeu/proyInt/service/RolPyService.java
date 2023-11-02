package pe.edu.upeu.proyInt.service;

import pe.edu.upeu.proyInt.entity.RolPyEntity;

import java.util.List;

public interface RolPyService {
    List<RolPyEntity> rolPyListar();
    RolPyEntity guardarRolPy(RolPyEntity rolPyEntity);
    RolPyEntity editarRolPy(int id, RolPyEntity rolPyEntity);
    void eliminarRolPy(int id);
}
