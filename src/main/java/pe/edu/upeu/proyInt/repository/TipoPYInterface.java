package pe.edu.upeu.proyInt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.proyInt.entity.TipoPYEntity;

@Repository
public interface TipoPYInterface extends JpaRepository<TipoPYEntity, Integer>{
    /*@Query("")
    TipoPYEntity findByDepartamento(String departamento);
    TipoPYEntity findByProvincia(String provincia);
    List<TipoPYEntity> listDepartamento();*/
}
