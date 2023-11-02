package pe.edu.upeu.proyInt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.proyInt.entity.RolEstudianteEntity;

@Repository
public interface RolEstudianteInterface extends JpaRepository<RolEstudianteEntity, Integer>{

}
