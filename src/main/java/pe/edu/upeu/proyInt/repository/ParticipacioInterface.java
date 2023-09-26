package pe.edu.upeu.proyInt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.proyInt.entity.ParticipacionEntity;

@Repository
public interface ParticipacioInterface extends JpaRepository<ParticipacionEntity, Integer>{

}
