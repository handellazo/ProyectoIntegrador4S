package pe.edu.upeu.proyInt.service;

import pe.edu.upeu.proyInt.entity.RolEstudianteEntity;

import java.util.List;

public interface RolEstudianteService {
    List<RolEstudianteEntity> rolEstudianteListar();
    RolEstudianteEntity guardarRolEstudiante(RolEstudianteEntity rolEstudianteEntity);
    RolEstudianteEntity editarRolEstudiante(int id, RolEstudianteEntity rolEstudianteEntity);
    void eliminarRolEstudiante(int id);
}
