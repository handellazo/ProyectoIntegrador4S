package pe.edu.upeu.proyInt.service;

import pe.edu.upeu.proyInt.entity.ProyectoEntity;

import java.util.List;

public interface ProyectoService {
    List<ProyectoEntity> proyectoListar();
    ProyectoEntity buscarProyectoPorID(int id);
    ProyectoEntity guardarProyecto(ProyectoEntity proyectoEntity);
    ProyectoEntity editarProyecto(int id,ProyectoEntity proyectoEntity);
    void elimirUsuario(int id);
}
