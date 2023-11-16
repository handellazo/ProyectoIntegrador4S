package pe.edu.upeu.proyInt.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.proyInt.dto.ProyectoDto;
import pe.edu.upeu.proyInt.entity.*;
import pe.edu.upeu.proyInt.repository.*;
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
    private TipoPYInterface tipoPyInterface;
    @Autowired
    private EpInterface epInterface;
    @Autowired
    private CursoSemestreInterface cursoSemestreInterface;

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
        ConvenioEntity convenioEncontrado = convenioInterface.findById(Integer.valueOf(proyectoDto.getConvenio())).orElse(null);
        UbicacionEntity ubicacionEncontrado = ubicacionInterface.findById(Integer.valueOf(proyectoDto.getUbicacion())).orElse(null);
        EpEntity epEncontrado = epInterface.findById(Integer.valueOf(proyectoDto.getEp())).orElse(null);
        TipoPYEntity tipoPyEncontrado = tipoPyInterface.findById(Integer.valueOf(proyectoDto.getTipoPY())).orElse(null);
        CursoSemestreEntity cursoSemestreEncontrado = cursoSemestreInterface.findById(Integer.valueOf(proyectoDto.getCursoSemestre())).orElse(null);

        ProyectoEntity nuevoProyecto = new ProyectoEntity();
        nuevoProyecto.setNombre(proyectoDto.getNombre());
        nuevoProyecto.setInicio(proyectoDto.getInicio());
        nuevoProyecto.setFin(proyectoDto.getFin());
        nuevoProyecto.setAnexo(proyectoDto.getAnexo());
        nuevoProyecto.setCiclo(proyectoDto.getCiclo());
        nuevoProyecto.setEstado(proyectoDto.getEstado());
        nuevoProyecto.setBeneficiarios(proyectoDto.getBeneficiarios());
        nuevoProyecto.setPresupuesto(proyectoDto.getPresupuesto());
        nuevoProyecto.setUrl_doc(proyectoDto.getUrl_doc());
        nuevoProyecto.setRepresentante(proyectoDto.getRepresentante());

        nuevoProyecto.setConvenio(convenioEncontrado);
        nuevoProyecto.setUbicacion(ubicacionEncontrado);
        nuevoProyecto.setEp(epEncontrado);
        nuevoProyecto.setTipoPY(tipoPyEncontrado);
        nuevoProyecto.setCursoSemestre(cursoSemestreEncontrado);

        return proyectoInterface.save(nuevoProyecto);

    }

    @Override
    public ProyectoEntity editarProyecto(int id, ProyectoEntity proyectoEntity) {
        ProyectoEntity proyectoEncontrado = proyectoInterface.findById(id).orElse(null);
        if (proyectoEncontrado != null) {
            proyectoEncontrado.setNombre(proyectoEntity.getNombre());
            proyectoEncontrado.setInicio(proyectoEntity.getInicio());
            proyectoEncontrado.setFin(proyectoEntity.getFin());
            proyectoEncontrado.setAnexo(proyectoEntity.getAnexo());
            proyectoEncontrado.setCiclo(proyectoEncontrado.getCiclo());
            proyectoEncontrado.setEstado(proyectoEntity.getEstado());
            proyectoEncontrado.setBeneficiarios(proyectoEntity.getBeneficiarios());
            proyectoEncontrado.setPresupuesto(proyectoEntity.getPresupuesto());
            proyectoEncontrado.setRepresentante(proyectoEntity.getRepresentante());
            proyectoEncontrado.setUrl_doc(proyectoEntity.getUrl_doc());
            proyectoEncontrado.setConvenio(proyectoEntity.getConvenio());
            proyectoEncontrado.setUbicacion(proyectoEntity.getUbicacion());
            proyectoEncontrado.setEp(proyectoEntity.getEp());
            proyectoEncontrado.setTipoPY(proyectoEntity.getTipoPY());
            proyectoEncontrado.setSemestre(proyectoEntity.getSemestre());
            proyectoEncontrado.setCursoSemestre(proyectoEntity.getCursoSemestre());
            return proyectoInterface.save(proyectoEncontrado);
        }
        return null;
    }

    @Override
    public void elimirUsuario(int id) {
        proyectoInterface.deleteById(id);
    }
}