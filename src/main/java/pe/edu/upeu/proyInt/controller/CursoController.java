package pe.edu.upeu.proyInt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.proyInt.dto.CursoDto;
import pe.edu.upeu.proyInt.entity.CursoEntity;
import pe.edu.upeu.proyInt.service.CursoService;

import java.util.List;

@RestController
@RequestMapping("/api/CURSO")
@CrossOrigin(origins = {"http://localhost:4200, http://localhost:8080 "})
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @GetMapping("/listCurso") //GET
    public ResponseEntity<List<CursoEntity>> listaCursos(){
        List<CursoEntity> cursos = cursoService.cursoListar();
        return new ResponseEntity<>(cursos, HttpStatus.OK);
    };

    @GetMapping("/buscarCursoPorId/{id}") //GET
    public ResponseEntity<CursoEntity> buscarCursoPorId(@PathVariable Integer id){
        CursoEntity curso = cursoService.buscarCursoPorId(id);
        return new ResponseEntity<>(curso, HttpStatus.OK);
    }

    @PostMapping("/addCurso") //POST
    public ResponseEntity<CursoEntity> crearCurso(@RequestBody CursoDto curso) {
        CursoEntity newCurso = cursoService.guardarCurso(curso);
        if (newCurso != null) {
            return new ResponseEntity<>(newCurso, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateCurso/{id}") //PUT
    public ResponseEntity<CursoEntity> updateCurso(@PathVariable Integer id, @RequestBody CursoDto newCurso) {
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
