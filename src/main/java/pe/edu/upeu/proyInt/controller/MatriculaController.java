package pe.edu.upeu.proyInt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.proyInt.dto.MatriculaDto;
import pe.edu.upeu.proyInt.entity.MatriculaEntity;
import pe.edu.upeu.proyInt.service.MatriculaService;

import java.util.List;

@RestController
@RequestMapping("/api/MATRICULA")
@CrossOrigin({"*"})
public class MatriculaController {
    @Autowired
    private MatriculaService matriculaService;

    @GetMapping("/listMatricula") //GET
    public ResponseEntity<List<MatriculaEntity>> listaMatriculas(){
        List<MatriculaEntity> matriculas = matriculaService.matriculaListar();
        return new ResponseEntity<>(matriculas, HttpStatus.OK);
    };

    @GetMapping("/buscarMatriculaPorId/{id}") //GET
    public ResponseEntity<MatriculaEntity> buscarMatriculaPorId(@PathVariable Integer id){
        MatriculaEntity matricula = matriculaService.buscarMatriculaPorId(id);
        return new ResponseEntity<>(matricula, HttpStatus.OK);
    }

    @PostMapping("/addMatricula") //POST
    public ResponseEntity<MatriculaEntity> crearMatricula(@RequestBody MatriculaDto matricula) {
        MatriculaEntity newMatricula = matriculaService.guardarMatricula(matricula);
        if (newMatricula != null) {
            return new ResponseEntity<>(newMatricula, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateMatricula/{id}") //PUT
    public ResponseEntity<MatriculaEntity> updateMatricula(@PathVariable Integer id, @RequestBody MatriculaDto newMatricula) {
        MatriculaEntity updateMatricula = matriculaService.editarMatricula(id,newMatricula);
        if (updateMatricula != null) {
            return new ResponseEntity<>(updateMatricula, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteMatricula/{id}") //DELETE
    public ResponseEntity<Void> deleteMatricula(@PathVariable Integer id) {
        matriculaService.eliminarMatricula(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
