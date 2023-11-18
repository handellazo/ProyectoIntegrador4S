package pe.edu.upeu.proyInt.service;

import pe.edu.upeu.proyInt.dto.EpDto;
import pe.edu.upeu.proyInt.entity.ConvenioEntity;
import pe.edu.upeu.proyInt.entity.EpEntity;

import java.util.List;

public interface EpService {
    List<EpEntity> epListar();
    EpEntity guardarEp(EpDto epDto);
    EpEntity buscarEpPorId(int id);
    EpEntity editarEp(int id, EpDto epDto);
    void eliminarEp(int id);
}
