package pe.edu.upeu.proyInt.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.proyInt.dto.GrupoPyDto;
import pe.edu.upeu.proyInt.entity.*;
import pe.edu.upeu.proyInt.repository.*;
import pe.edu.upeu.proyInt.service.GrupoPyService;
import pe.edu.upeu.proyInt.service.exception.EntityNotFoundException;

import java.util.List;

@Service
public class GrupoPyServiceImpl implements GrupoPyService {

    @Autowired
    private GrupoPyInterface grupoPyInterface;
    @Autowired
    private ProyectoInterface proyectoInterface;
    @Autowired
    private SesionInterface sesionInterface;

    @Override
    public List<GrupoPyEntity> grupoPyListar() {
        return grupoPyInterface.findAll();
    }

    @Override
    public GrupoPyEntity buscarGrupoPyPorId(int id) {
        return grupoPyInterface.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("No se encuentra datos con el ID: " + id)
                );
    }

    @Override
    public GrupoPyEntity guardarGrupoPy(GrupoPyDto grupoPyDto) {
        ProyectoEntity proyectoEncontrado = proyectoInterface.findById(grupoPyDto.getProyecto()).orElse(null);
        SesionEntity sesionEncontrado = sesionInterface.findById(grupoPyDto.getSesion()).orElse(null);

        GrupoPyEntity nuevoGrupoPy = new GrupoPyEntity();
        nuevoGrupoPy.setNombre(grupoPyDto.getNombre());
        nuevoGrupoPy.setProyecto(proyectoEncontrado);
        nuevoGrupoPy.setSesion(sesionEncontrado);
        return grupoPyInterface.save(nuevoGrupoPy);
    }

    @Override
    public GrupoPyEntity editarGrupoPy(int id, GrupoPyDto grupoPyDto) {
        GrupoPyEntity grupoPyEncontrado = grupoPyInterface.findById(id).orElse(null);
        ProyectoEntity proyectoEncontrado = proyectoInterface.findById(grupoPyDto.getProyecto()).orElse(null);
        SesionEntity sesionEncontrado = sesionInterface.findById(grupoPyDto.getSesion()).orElse(null);

        if (grupoPyEncontrado != null){
            grupoPyEncontrado.setNombre(grupoPyDto.getNombre());
            grupoPyEncontrado.setProyecto(proyectoEncontrado);
            grupoPyEncontrado.setSesion(sesionEncontrado);
            return grupoPyInterface.save(grupoPyEncontrado);
        }
        return null;
    }

    @Override
    public void eliminarGrupoPy(int id) {
        grupoPyInterface.deleteById(id);
    }
}