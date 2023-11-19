package pe.edu.upeu.proyInt.service;

import pe.edu.upeu.proyInt.dto.ValEstadoProyDto;
import pe.edu.upeu.proyInt.entity.ValEstadoProyEntity;

import java.util.List;

public interface ValEstadoProyService {
    List<ValEstadoProyEntity> valEstadoProyListar();
    ValEstadoProyEntity buscarValEstadoProyPorId(int id);
    ValEstadoProyEntity guardarValEstadoProy(ValEstadoProyDto valEstadoProyDto);
    ValEstadoProyEntity editarValEstadoProy(int id, ValEstadoProyDto valEstadoProyDto);
    void eliminarValEstadoProy(int id);
}
