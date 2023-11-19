package pe.edu.upeu.proyInt.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.proyInt.dto.ValEstadoProyDto;
import pe.edu.upeu.proyInt.entity.*;
import pe.edu.upeu.proyInt.repository.*;
import pe.edu.upeu.proyInt.service.ValEstadoProyService;
import pe.edu.upeu.proyInt.service.exception.EntityNotFoundException;

import java.util.List;

@Service
public class ValEstadoProyServiceImpl implements ValEstadoProyService {

    @Autowired
    private ValEstadoProyInterface valEstadoProyInterface;
    @Autowired
    private EstadoProyInterface estadoProyInterface;
    @Autowired
    private ProyectoInterface ProyectoInterface;

    @Override
    public List<ValEstadoProyEntity> valEstadoProyListar() {
        return valEstadoProyInterface.findAll();
    }

    @Override
    public ValEstadoProyEntity buscarValEstadoProyPorId(int id) {
        return valEstadoProyInterface.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("No se encuentra datos con el ID: " + id)
                );
    }

    @Override
    public ValEstadoProyEntity guardarValEstadoProy(ValEstadoProyDto valEstadoProyDto) {
        EstadoProyEntity estadoProyEncontrado = estadoProyInterface.findById(valEstadoProyDto.getEstadoProy()).orElse(null);
        ProyectoEntity proyectoEncontrado = ProyectoInterface.findById(valEstadoProyDto.getProyecto()).orElse(null);

        ValEstadoProyEntity nuevoValEstadoProy = new ValEstadoProyEntity();
        nuevoValEstadoProy.setProyecto(proyectoEncontrado);
        nuevoValEstadoProy.setEstadoProy(estadoProyEncontrado);
        nuevoValEstadoProy.setEstado(valEstadoProyDto.getEstado());
        nuevoValEstadoProy.setCodigo(valEstadoProyDto.getCodigo());
        return valEstadoProyInterface.save(nuevoValEstadoProy);
    }

    @Override
    public ValEstadoProyEntity editarValEstadoProy(int id, ValEstadoProyDto valEstadoProyDto) {
        ValEstadoProyEntity valEstadoProyEncontrado = valEstadoProyInterface.findById(id).orElse(null);
        EstadoProyEntity estadoProyEncontrado = estadoProyInterface.findById(valEstadoProyDto.getEstadoProy()).orElse(null);
        ProyectoEntity proyectoEncontrado = ProyectoInterface.findById(valEstadoProyDto.getProyecto()).orElse(null);

        if (valEstadoProyEncontrado != null){
            valEstadoProyEncontrado.setProyecto(proyectoEncontrado);
            valEstadoProyEncontrado.setEstadoProy(estadoProyEncontrado);
            valEstadoProyEncontrado.setEstado(valEstadoProyDto.getEstado());
            valEstadoProyEncontrado.setCodigo(valEstadoProyDto.getCodigo());
            return valEstadoProyInterface.save(valEstadoProyEncontrado);
        }
        return null;
    }

    @Override
    public void eliminarValEstadoProy(int id) {
        valEstadoProyInterface.deleteById(id);
    }
}