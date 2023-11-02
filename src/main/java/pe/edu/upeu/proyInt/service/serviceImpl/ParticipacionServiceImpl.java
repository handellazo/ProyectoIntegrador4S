package pe.edu.upeu.proyInt.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.proyInt.entity.ParticipacionEntity;
import pe.edu.upeu.proyInt.repository.ParticipacioInterface;
import pe.edu.upeu.proyInt.service.ParticipacionService;
import pe.edu.upeu.proyInt.service.exception.EntityNotFoundException;

import java.util.List;

@Service
public class ParticipacionServiceImpl implements ParticipacionService {

    @Autowired
    private ParticipacioInterface participacionInterface;

    public List<ParticipacionEntity> participacionListar() {
        return participacionInterface.findAll();
    }

    @Override
    public ParticipacionEntity buscarParticipacionPorID(int id) {
        return participacionInterface.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("No se encuentra datos con el ID: " + id)
                );
    }

    @Override
    public ParticipacionEntity guardarParticipacion(ParticipacionEntity participacionEntity) {
        ParticipacionEntity nuevoParticipacion = new ParticipacionEntity();
        nuevoParticipacion.setUrlinforme(participacionEntity.getUrlinforme());
        nuevoParticipacion.setPartporcen(participacionEntity.getPartporcen());
        nuevoParticipacion.setMatricula(participacionEntity.getMatricula());
        nuevoParticipacion.setAsistencia(participacionEntity.getAsistencia());
        return participacionInterface.save(nuevoParticipacion);
    }

    @Override
    public ParticipacionEntity editarParticipacion(int id, ParticipacionEntity participacionEntity) {
        ParticipacionEntity participacionEncontrado = participacionInterface.findById(id).orElse(null);
        if (participacionEncontrado != null){
            participacionEncontrado.setUrlinforme(participacionEntity.getUrlinforme());
            participacionEncontrado.setPartporcen(participacionEntity.getPartporcen());
            participacionEncontrado.setMatricula(participacionEntity.getMatricula());
            participacionEncontrado.setAsistencia(participacionEntity.getAsistencia());
            return participacionInterface.save(participacionEncontrado);
        }
        return null;
    }

    @Override
    public void eliminarParticipacion(int id) {
        participacionInterface.deleteById(id);
    }
}