package pe.edu.upeu.proyInt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.proyInt.entity.EstudianteEntity;

@Repository
public interface EstudianteInterface extends JpaRepository<EstudianteEntity, Integer>{
    /*@Query("")
    EstudianteEntity findByDepartamento(String departamento);
    EstudianteEntity findByProvincia(String provincia);
    List<EstudianteEntity> listDepartamento();*/
}
