package pe.edu.upeu.proyInt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.proyInt.dto.CursoSemestreDto;
import pe.edu.upeu.proyInt.entity.CursoEntity;
import pe.edu.upeu.proyInt.entity.CursoSemestreEntity;
import pe.edu.upeu.proyInt.service.CursoSemestreService;

import java.util.List;

@RestController
@RequestMapping("/api/CURSOSEMESTRE")
@CrossOrigin({"*"})
public class CursoSemestreController {
    @Autowired
    private CursoSemestreService cursoSemestreService;

    @GetMapping("/listCursoSemestre") //GET
    public ResponseEntity<List<CursoSemestreEntity>> listaCursosSemestre(){
        List<CursoSemestreEntity> cursosSemestre = cursoSemestreService.cursoSemestreListar();
        return new ResponseEntity<>(cursosSemestre, HttpStatus.OK);
    };

    @GetMapping("/buscarCursoSemestrePorId/{id}") //GET
    public ResponseEntity<CursoSemestreEntity> buscarCursoSemestrePorId(@PathVariable Integer id){
        CursoSemestreEntity cursoSemestre = cursoSemestreService.buscarCursoSemestrePorId(id);
        return new ResponseEntity<>(cursoSemestre, HttpStatus.OK);
    }

    @PostMapping("/addCursoSemestre") //POST
    public ResponseEntity<CursoSemestreEntity> crearCursoSemestre(@RequestBody CursoSemestreDto cursoSemestre) {
        CursoSemestreEntity newCursoSemestre = cursoSemestreService.guardarCursoSemestre(cursoSemestre);
        if (newCursoSemestre != null) {
            return new ResponseEntity<>(newCursoSemestre, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateCursoSemestre/{id}") //PUT
    public ResponseEntity<CursoSemestreEntity> updateCursoSemestre(@PathVariable Integer id, @RequestBody CursoSemestreDto newCursoSemestre) {
        CursoSemestreEntity updateCursoSemestre = cursoSemestreService.editarCursoSemestre(id,newCursoSemestre);
        if (updateCursoSemestre != null) {
            return new ResponseEntity<>(updateCursoSemestre, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteCursoSemestre/{id}") //DELETE
    public ResponseEntity<Void> deleteCursoSemestre(@PathVariable Integer id) {
        cursoSemestreService.eliminarCursoSemestre(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
