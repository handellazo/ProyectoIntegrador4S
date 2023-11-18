package pe.edu.upeu.proyInt.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.proyInt.dto.ParticipacionDto;
import pe.edu.upeu.proyInt.entity.GrupoPyEntity;
import pe.edu.upeu.proyInt.entity.*;
import pe.edu.upeu.proyInt.repository.*;
import pe.edu.upeu.proyInt.service.ParticipacionService;
import pe.edu.upeu.proyInt.service.exception.EntityNotFoundException;

import java.util.List;

@Service
public class ParticipacionServiceImpl implements ParticipacionService {

    @Autowired
    private ParticipacioInterface participacionInterface;
    @Autowired
    private MatriculaInterface matriculaInterface;
    @Autowired
    private GrupoPyInterface grupoPyInterface;
    @Autowired
    private RolPyInterface rolPyInterface;

    public List<ParticipacionEntity> participacionListar() {
        return participacionInterface.findAll();
    }

    @Override
    public ParticipacionEntity buscarParticipacionPorId(int id) {
        return participacionInterface.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("No se encuentra datos con el ID: " + id)
                );
    }

    @Override
    public ParticipacionEntity guardarParticipacion(ParticipacionDto participacionDto) {
        MatriculaEntity matriculaEncontrado = matriculaInterface.findById(participacionDto.getMatricula()).orElse(null);
        GrupoPyEntity grupoPyEncontrado = grupoPyInterface.findById(participacionDto.getGrupopy()).orElse(null);
        RolPyEntity rolPyEncontrado = rolPyInterface.findById(participacionDto.getRolpy()).orElse(null);

        ParticipacionEntity nuevoParticipacion = new ParticipacionEntity();
        nuevoParticipacion.setUrlinforme(participacionDto.getUrlinforme());
        nuevoParticipacion.setPartporcen(participacionDto.getPartporcen());
        nuevoParticipacion.setMatricula(matriculaEncontrado);
        nuevoParticipacion.setAsistencia(participacionDto.getAsistencia());
        nuevoParticipacion.setAsistenciaval(participacionDto.getAsistenciaval());
        nuevoParticipacion.setNota(participacionDto.getNota());
        nuevoParticipacion.setGrupopy(grupoPyEncontrado);
        nuevoParticipacion.setRolpy(rolPyEncontrado);
        return participacionInterface.save(nuevoParticipacion);
    }

    @Override
    public ParticipacionEntity editarParticipacion(int id, ParticipacionDto participacionDto
    ) {
        ParticipacionEntity participacionEncontrado = participacionInterface.findById(id).orElse(null);
        MatriculaEntity matriculaEncontrado = matriculaInterface.findById(participacionDto.getMatricula()).orElse(null);
        GrupoPyEntity grupoPyEncontrado = grupoPyInterface.findById(participacionDto.getGrupopy()).orElse(null);
        RolPyEntity rolPyEncontrado = rolPyInterface.findById(participacionDto.getRolpy()).orElse(null);

        if (participacionEncontrado != null){
            participacionEncontrado.setUrlinforme(participacionDto.getUrlinforme());
            participacionEncontrado.setPartporcen(participacionDto.getPartporcen());
            participacionEncontrado.setMatricula(matriculaEncontrado);
            participacionEncontrado.setAsistencia(participacionDto.getAsistencia());
            participacionEncontrado.setAsistenciaval(participacionDto.getAsistenciaval());
            participacionEncontrado.setNota(participacionDto.getNota());
            participacionEncontrado.setGrupopy(grupoPyEncontrado);
            participacionEncontrado.setRolpy(rolPyEncontrado);
            participacionEncontrado.setAsistencia(participacionEncontrado.getAsistencia());
            return participacionInterface.save(participacionEncontrado);
        }
        return null;
    }

    @Override
    public void eliminarParticipacion(int id) {
        participacionInterface.deleteById(id);
    }
}