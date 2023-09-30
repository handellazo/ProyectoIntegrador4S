package pe.edu.upeu.proyInt.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.proyInt.dto.ProyectoDto;
import pe.edu.upeu.proyInt.entity.ConvenioEntity;
import pe.edu.upeu.proyInt.entity.CursoEntity;
import pe.edu.upeu.proyInt.entity.ProyectoEntity;
import pe.edu.upeu.proyInt.entity.UbicacionEntity;
import pe.edu.upeu.proyInt.repository.ConvenioInterface;
import pe.edu.upeu.proyInt.repository.CursoInterface;
import pe.edu.upeu.proyInt.repository.ProyectoInterface;
import pe.edu.upeu.proyInt.repository.UbicacionInterface;
import pe.edu.upeu.proyInt.service.ProyectoService;
import pe.edu.upeu.proyInt.service.exception.EntityNotFoundException;

import java.util.List;

@Service
public class ProyectoServiceImpl implements ProyectoService {

    @Autowired
    private ProyectoInterface proyectoInterface;
    @Autowired
    private ConvenioInterface convenioInterface;
    @Autowired
    private UbicacionInterface ubicacionInterface;
    @Autowired
    private CursoInterface cursoInterface;

    @Override
    public List<ProyectoEntity> proyectoListar() {
        return proyectoInterface.findAll();
    }

    @Override
    public ProyectoEntity buscarProyectoPorID(int id) {
        return proyectoInterface.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("No se encuentra datos con el ID: " + id)
                );
    }

    @Override
    public ProyectoEntity guardarProyecto(ProyectoDto proyectoDto) {
        ConvenioEntity convenioEncontrado = convenioInterface.findById(proyectoDto.getConvenio()).orElse(null);
        UbicacionEntity ubicacionEncontrado = ubicacionInterface.findById(proyectoDto.getUbicacion()).orElse(null);
        CursoEntity cursoEncontrado = cursoInterface.findById(proyectoDto.getCurso()).orElse(null);

        ProyectoEntity nuevoProyecto = new ProyectoEntity();
        nuevoProyecto.setNombre(proyectoDto.getNombre());
        nuevoProyecto.setInicio(proyectoDto.getInicio());
        nuevoProyecto.setFin(proyectoDto.getFin());
        nuevoProyecto.setTipo(proyectoDto.getTipo());
        nuevoProyecto.setAnexo(proyectoDto.getAnexo());
        nuevoProyecto.setBeneficiarios(proyectoDto.getBeneficiarios());
        nuevoProyecto.setFacultad(proyectoDto.getFacultad());
        nuevoProyecto.setEp(proyectoDto.getEp());
        nuevoProyecto.setPresupuesto(proyectoDto.getPresupuesto());
        nuevoProyecto.setConvenio(convenioEncontrado);
        nuevoProyecto.setCurso(cursoEncontrado);
        nuevoProyecto.setUbicacion(ubicacionEncontrado);
        return proyectoInterface.save(nuevoProyecto);

    }

    @Override
    public ProyectoEntity editarProyecto(int id, ProyectoEntity proyectoEntity) {
        ProyectoEntity proyectoEncontrado = proyectoInterface.findById(id).orElse(null);
        if (proyectoEncontrado != null) {
            proyectoEncontrado.setNombre(proyectoEntity.getNombre());
            proyectoEncontrado.setNombre(proyectoEntity.getNombre());
            proyectoEncontrado.setInicio(proyectoEntity.getInicio());
            proyectoEncontrado.setFin(proyectoEntity.getFin());
            proyectoEncontrado.setAnexo(proyectoEntity.getAnexo());
            return proyectoInterface.save(proyectoEncontrado);
        }
        return null;
    }

    @Override
    public void elimirUsuario(int id) {
        proyectoInterface.deleteById(id);
    }
}