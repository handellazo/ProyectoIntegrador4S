package pe.edu.upeu.proyInt.service;

import pe.edu.upeu.proyInt.entity.DocenteEntity;

import java.util.List;

public interface DocenteService {
    List<DocenteEntity> docenteListar();
    DocenteEntity guardarDocente(DocenteEntity docenteEntity);
    DocenteEntity editarDocente(int id, DocenteEntity docenteEntity);
    void eliminarDocente(int id);
}
