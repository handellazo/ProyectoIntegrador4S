package pe.edu.upeu.proyInt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.proyInt.dto.EstudianteDto;
import pe.edu.upeu.proyInt.entity.EstudianteEntity;
import pe.edu.upeu.proyInt.service.EstudianteService;

import java.util.List;

@RestController
@RequestMapping("/api/ESTUDIANTE")
@CrossOrigin(origins = {"http://localhost:4200, http://localhost:8080 "})
public class EstudianteController {
    @Autowired
    private EstudianteService estudianteService;

    @GetMapping("/listEstudiante") //GET
    public ResponseEntity<List<EstudianteEntity>> listaEstudiantes(){
        List<EstudianteEntity> estudiantes = estudianteService.estudianteListar();
        return new ResponseEntity<>(estudiantes, HttpStatus.OK);
    };

    @GetMapping("/buscarEstudiantePorId/{id}") //GET
    public ResponseEntity<EstudianteEntity> buscarEstudiantePorId(@PathVariable Integer id){
        EstudianteEntity estudiante = estudianteService.buscarEstudiantePorId(id);
        return new ResponseEntity<>(estudiante, HttpStatus.OK);
    }

    @PostMapping("/addEstudiante") //POST
    public ResponseEntity<EstudianteEntity> crearEstudiante(@RequestBody EstudianteDto estudiante) {
        EstudianteEntity newEstudiante = estudianteService.guardarEstudiante(estudiante);
        if (newEstudiante != null) {
            return new ResponseEntity<>(newEstudiante, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateEstudiante/{id}") //PUT
    public ResponseEntity<EstudianteEntity> updateEstudiante(@PathVariable Integer id, @RequestBody EstudianteDto newEstudiante) {
        EstudianteEntity updateEstudiante = estudianteService.editarEstudiante(id,newEstudiante);
        if (updateEstudiante != null) {
            return new ResponseEntity<>(updateEstudiante, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteEstudiante/{id}") //DELETE
    public ResponseEntity<Void> deleteEstudiante(@PathVariable Integer id) {
        estudianteService.eliminarEstudiante(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
