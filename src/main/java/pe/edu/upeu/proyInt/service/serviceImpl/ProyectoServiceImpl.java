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
    @Autowired
    private SemestreInterface semestreInterface;

    @Override
    public List<ProyectoEntity> proyectoListar() {
        return proyectoInterface.findAll();
    }

    @Override
    public ProyectoEntity buscarProyectoPorId(int id) {
        return proyectoInterface.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("No se encuentra datos con el ID: " + id)
                );
    }

    @Override
    public ProyectoEntity guardarProyecto(ProyectoDto proyectoDto) {
        ConvenioEntity convenioEncontrado = convenioInterface.findById(proyectoDto.getConvenio()).orElse(null);
        UbicacionEntity ubicacionEncontrado = ubicacionInterface.findById(proyectoDto.getUbicacion()).orElse(null);
        EpEntity epEncontrado = epInterface.findById(proyectoDto.getEp()).orElse(null);
        TipoPYEntity tipoPyEncontrado = tipoPyInterface.findById(proyectoDto.getTipoPY()).orElse(null);
        CursoSemestreEntity cursoSemestreEncontrado = cursoSemestreInterface.findById(proyectoDto.getCursoSemestre()).orElse(null);
        SemestreEntity semestreEncontrado = semestreInterface.findById(proyectoDto.getSemestre()).orElse(null);


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
        nuevoProyecto.setSemestre(semestreEncontrado);
        nuevoProyecto.setCursoSemestre(cursoSemestreEncontrado);

        return proyectoInterface.save(nuevoProyecto);

    }

    @Override
    public ProyectoEntity editarProyecto(int id, ProyectoDto proyectoDto) {
        ProyectoEntity proyectoEncontrado = proyectoInterface.findById(id).orElse(null);
        ConvenioEntity convenioEncontrado = convenioInterface.findById(proyectoDto.getId()).orElse(null);
        UbicacionEntity ubicacionEncontrado = ubicacionInterface.findById(proyectoDto.getId()).orElse(null);
        EpEntity epEncontrado = epInterface.findById(proyectoDto.getId()).orElse(null);
        TipoPYEntity tipoPyEncontrado = tipoPyInterface.findById(proyectoDto.getId()).orElse(null);
        SemestreEntity semestreEncontrado = semestreInterface.findById(proyectoDto.getId()).orElse(null);
        CursoSemestreEntity cursoSemestreEncontrado = cursoSemestreInterface.findById(proyectoDto.getId()).orElse(null);


        if (proyectoEncontrado != null) {
            proyectoEncontrado.setNombre(proyectoDto.getNombre());
            proyectoEncontrado.setInicio(proyectoDto.getInicio());
            proyectoEncontrado.setFin(proyectoDto.getFin());
            proyectoEncontrado.setAnexo(proyectoDto.getAnexo());
            proyectoEncontrado.setCiclo(proyectoEncontrado.getCiclo());
            proyectoEncontrado.setEstado(proyectoDto.getEstado());
            proyectoEncontrado.setBeneficiarios(proyectoDto.getBeneficiarios());
            proyectoEncontrado.setPresupuesto(proyectoDto.getPresupuesto());
            proyectoEncontrado.setRepresentante(proyectoDto.getRepresentante());
            proyectoEncontrado.setUrl_doc(proyectoDto.getUrl_doc());
            proyectoEncontrado.setConvenio(convenioEncontrado); //FK
            proyectoEncontrado.setUbicacion(ubicacionEncontrado); //FK
            proyectoEncontrado.setEp(epEncontrado); //FK
            proyectoEncontrado.setTipoPY(tipoPyEncontrado); //FK
            proyectoEncontrado.setSemestre(semestreEncontrado); //FK
            proyectoEncontrado.setCursoSemestre(cursoSemestreEncontrado); //FK
            return proyectoInterface.save(proyectoEncontrado);
        }
        return null;
    }

    @Override
    public void eliminarProyecto(int id) {
        proyectoInterface.deleteById(id);
    }
}