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
        nuevoParticipacion.setCiclo(participacionEntity.getCiclo());
        nuevoParticipacion.setAño(participacionEntity.getAño());
        nuevoParticipacion.setHoras(participacionEntity.getHoras());
        nuevoParticipacion.setEstadoPart(participacionEntity.getEstadoPart());
        return participacionInterface.save(nuevoParticipacion);
    }

    @Override
    public ParticipacionEntity editarParticipacion(int id, ParticipacionEntity participacionEntity) {
        ParticipacionEntity participacionEncontrado = participacionInterface.findById(id).orElse(null);
        if (participacionEncontrado != null){
            participacionEncontrado.setCiclo(participacionEntity.getCiclo());
            participacionEncontrado.setAño(participacionEntity.getAño());
            participacionEncontrado.setHoras(participacionEntity.getHoras());
            participacionEncontrado.setEstadoPart(participacionEntity.getEstadoPart());
            return participacionInterface.save(participacionEncontrado);
        }
        return null;
    }

    @Override
    public void eliminarParticipacion(int id) {
        participacionInterface.deleteById(id);
    }
}