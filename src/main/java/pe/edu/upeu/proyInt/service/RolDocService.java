package pe.edu.upeu.proyInt.service;

import pe.edu.upeu.proyInt.entity.RolDocEntity;

import java.util.List;

public interface RolDocService {
    List<RolDocEntity> rolDocListar();
    RolDocEntity guardarRolDoc(RolDocEntity rolDocEntity);
    RolDocEntity editarRolDoc(int id, RolDocEntity rolDocEntity);
    void eliminarRolDoc(int id);
}
