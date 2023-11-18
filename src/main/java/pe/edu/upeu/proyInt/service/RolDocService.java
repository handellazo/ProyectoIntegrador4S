package pe.edu.upeu.proyInt.service;

import pe.edu.upeu.proyInt.dto.RolDocDto;
import pe.edu.upeu.proyInt.entity.ProyectoEntity;
import pe.edu.upeu.proyInt.entity.RolDocEntity;

import java.util.List;

public interface RolDocService {
    List<RolDocEntity> rolDocListar();
    RolDocEntity buscarRolDocPorId(int id);
    RolDocEntity guardarRolDoc(RolDocDto rolDocDto);
    RolDocEntity editarRolDoc(int id, RolDocDto rolDocDto);
    void eliminarRolDoc(int id);
}
