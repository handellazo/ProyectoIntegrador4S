package pe.edu.upeu.proyInt.service;

import pe.edu.upeu.proyInt.dto.RolEstudianteDto;
import pe.edu.upeu.proyInt.entity.ProyectoEntity;
import pe.edu.upeu.proyInt.entity.RolEstudianteEntity;

import java.util.List;

public interface RolEstudianteService {
    List<RolEstudianteEntity> rolEstudianteListar();
    RolEstudianteEntity buscarRolEstudiantePorId(int id);
    RolEstudianteEntity guardarRolEstudiante(RolEstudianteDto rolEstudianteDto);
    RolEstudianteEntity editarRolEstudiante(int id, RolEstudianteDto rolEstudianteDto);
    void eliminarRolEstudiante(int id);
}
