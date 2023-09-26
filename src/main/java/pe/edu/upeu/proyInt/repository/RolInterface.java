package pe.edu.upeu.proyInt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.proyInt.entity.RolEntity;

@Repository
public interface RolInterface extends JpaRepository<RolEntity, Integer>{

}
