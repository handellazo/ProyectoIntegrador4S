package pe.edu.upeu.proyInt.service;

import pe.edu.upeu.proyInt.entity.ConvenioEntity;

import java.util.List;

public interface ConvenioService {
    List<ConvenioEntity> convenioListar();
    ConvenioEntity buscarConvenioPorID(int id);
    ConvenioEntity guardarConvenio(ConvenioEntity convenioEntity);
    ConvenioEntity editarConvenio(int id, ConvenioEntity convenioEntity);
    void eliminarConvenio(int id);
}
