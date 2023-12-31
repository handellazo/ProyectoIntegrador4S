package pe.edu.upeu.proyInt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.proyInt.dto.SemestreDto;
import pe.edu.upeu.proyInt.entity.SemestreEntity;
import pe.edu.upeu.proyInt.service.SemestreService;

import java.util.List;

@RestController
@RequestMapping("/api/SEMESTRE")
@CrossOrigin(origins = {"http://localhost:4200, http://localhost:8080 "})
public class SemestreController {
    @Autowired
    private SemestreService semestreService;

    @GetMapping("/listSemestre") //GET
    public ResponseEntity<List<SemestreEntity>> listaSemestres(){
        List<SemestreEntity> semestres = semestreService.semestreListar();
        return new ResponseEntity<>(semestres, HttpStatus.OK);
    };

    @GetMapping("/buscarSemestrePorId/{id}") //GET
    public ResponseEntity<SemestreEntity> buscarCursoporId(@PathVariable Integer id){
        SemestreEntity semestre = semestreService.buscarSemestrePorId(id);
        return new ResponseEntity<>(semestre, HttpStatus.OK);
    }

    @PostMapping("/addSemestre") //POST
    public ResponseEntity<SemestreEntity> crearSemestre(@RequestBody SemestreDto semestre) {
        SemestreEntity newSemestre = semestreService.guardarSemestre(semestre);
        if (newSemestre != null) {
            return new ResponseEntity<>(newSemestre, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateSemestre/{id}") //PUT
    public ResponseEntity<SemestreEntity> updateSemestre(@PathVariable Integer id, @RequestBody SemestreDto newSemestre) {
        SemestreEntity updateSemestre = semestreService.editarSemestre(id,newSemestre);
        if (updateSemestre != null) {
            return new ResponseEntity<>(updateSemestre, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteSemestre/{id}") //DELETE
    public ResponseEntity<Void> deleteSemestre(@PathVariable Integer id) {
        semestreService.eliminarSemestre(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
