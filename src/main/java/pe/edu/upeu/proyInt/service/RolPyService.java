package pe.edu.upeu.proyInt.service;

import pe.edu.upeu.proyInt.dto.RolPyDto;
import pe.edu.upeu.proyInt.entity.ProyectoEntity;
import pe.edu.upeu.proyInt.entity.RolPyEntity;

import java.util.List;

public interface RolPyService {
    List<RolPyEntity> rolPyListar();
    RolPyEntity buscarRolPyPorId(int id);
    RolPyEntity guardarRolPy(RolPyDto rolPyDto);
    RolPyEntity editarRolPy(int id, RolPyDto rolPyDto);
    void eliminarRolPy(int id);
}
