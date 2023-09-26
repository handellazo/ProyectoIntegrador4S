package pe.edu.upeu.proyInt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.proyInt.entity.ConvenioEntity;
@Repository
public interface ConvenioInterface extends JpaRepository<ConvenioEntity, Integer> {
}
