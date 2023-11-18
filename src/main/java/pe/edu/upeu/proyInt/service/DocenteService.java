package pe.edu.upeu.proyInt.service;

import pe.edu.upeu.proyInt.dto.DocenteDto;
import pe.edu.upeu.proyInt.entity.ConvenioEntity;
import pe.edu.upeu.proyInt.entity.DocenteEntity;

import java.util.List;

public interface DocenteService {
    List<DocenteEntity> docenteListar();
    DocenteEntity buscarDocentePorId(int id);
    DocenteEntity guardarDocente(DocenteDto docenteDto);
    DocenteEntity editarDocente(int id, DocenteDto docenteDto);
    void eliminarDocente(int id);
}
