package pe.edu.upeu.proyInt.service;

import pe.edu.upeu.proyInt.dto.ConvenioDto;
import pe.edu.upeu.proyInt.entity.ConvenioEntity;

import java.util.List;

public interface ConvenioService {
    List<ConvenioEntity> convenioListar();
    ConvenioEntity buscarConvenioPorId(int id);
    ConvenioEntity guardarConvenio(ConvenioDto convenioDto);
    ConvenioEntity editarConvenio(int id, ConvenioDto convenioDto);
    void eliminarConvenio(int id);
}
