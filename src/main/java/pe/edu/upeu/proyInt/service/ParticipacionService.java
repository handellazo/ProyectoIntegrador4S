package pe.edu.upeu.proyInt.service;

import pe.edu.upeu.proyInt.dto.ParticipacionDto;
import pe.edu.upeu.proyInt.entity.ParticipacionEntity;

import java.util.List;

public interface ParticipacionService {
    List<ParticipacionEntity> participacionListar();
    ParticipacionEntity buscarParticipacionPorId(int id);
    ParticipacionEntity guardarParticipacion(ParticipacionDto participacionDto);
    ParticipacionEntity editarParticipacion(int id, ParticipacionDto participacionDto);
    void eliminarParticipacion(int id);
}
