package pe.edu.upeu.proyInt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.proyInt.entity.SemestreEntity;

@Repository
public interface SemestreInterface extends JpaRepository<SemestreEntity, Integer>{
    /*@Query("")
    SemestreEntity findByDepartamento(String departamento);
    SemestreEntity findByProvincia(String provincia);
    List<SemestreEntity> listDepartamento();*/
}
