package pe.edu.upeu.proyInt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.proyInt.entity.CursoEntity;
import pe.edu.upeu.proyInt.service.CursoService;

import java.util.List;

@RestController
@RequestMapping("/api/CURSO")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @GetMapping("/listCurso") //GET
    public ResponseEntity<List<CursoEntity>> listaCursos(){
        List<CursoEntity> cursos = cursoService.cursoListar();
        return new ResponseEntity<>(cursos, HttpStatus.OK);
    };

    @PostMapping("/addCurso") //POST
    public ResponseEntity<CursoEntity> crearCurso(@RequestBody CursoEntity curso) {
        CursoEntity newCurso = cursoService.guardarCurso(curso);
        if (newCurso != null) {
            return new ResponseEntity<>(newCurso, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateCurso/{id}") //PUT
    public ResponseEntity<CursoEntity> updateCurso(@PathVariable Integer id, @RequestBody CursoEntity newCurso) {
        CursoEntity updateCurso = cursoService.editarCurso(id,newCurso);
        if (updateCurso != null) {
            return new ResponseEntity<>(updateCurso, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteCurso/{id}") //DELETE
    public ResponseEntity<Void> deleteCurso(@PathVariable Integer id) {
        cursoService.eliminarCurso(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
