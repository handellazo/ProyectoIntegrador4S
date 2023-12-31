package pe.edu.upeu.proyInt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.proyInt.dto.RolEstudianteDto;
import pe.edu.upeu.proyInt.entity.RolEstudianteEntity;
import pe.edu.upeu.proyInt.service.RolEstudianteService;

import java.util.List;

@RestController
@RequestMapping("/api/ROLESTUDIANTE")
@CrossOrigin(origins = {"http://localhost:4200, http://localhost:8080 "})
public class RolEstudianteController {
    @Autowired
    private RolEstudianteService rolEstudianteService;

    @GetMapping("/listRolEstudiante") //GET
    public ResponseEntity<List<RolEstudianteEntity>> listaRolEstudiantes(){
        List<RolEstudianteEntity> rolEstudiantes = rolEstudianteService.rolEstudianteListar();
        return new ResponseEntity<>(rolEstudiantes, HttpStatus.OK);
    };

    @GetMapping("/buscarRolEstudiantePorId/{id}") //GET
    public ResponseEntity<RolEstudianteEntity> buscarRolEstudiantePorId(@PathVariable Integer id){
        RolEstudianteEntity rolEstudiante = rolEstudianteService.buscarRolEstudiantePorId(id);
        return new ResponseEntity<>(rolEstudiante, HttpStatus.OK);
    }

    @PostMapping("/addRolEstudiante") //POST
    public ResponseEntity<RolEstudianteEntity> crearRolEstudiante(@RequestBody RolEstudianteDto rolEstudiante) {
        RolEstudianteEntity newRolEstudiante = rolEstudianteService.guardarRolEstudiante(rolEstudiante);
        if (newRolEstudiante != null) {
            return new ResponseEntity<>(newRolEstudiante, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateRolEstudiante/{id}") //PUT
    public ResponseEntity<RolEstudianteEntity> updateRolEstudiante(@PathVariable Integer id, @RequestBody RolEstudianteDto newRolEstudiante) {
        RolEstudianteEntity updateRolEstudiante = rolEstudianteService.editarRolEstudiante(id,newRolEstudiante);
        if (updateRolEstudiante != null) {
            return new ResponseEntity<>(updateRolEstudiante, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteRolEstudiante/{id}") //DELETE
    public ResponseEntity<Void> deleteRolEstudiante(@PathVariable Integer id) {
        rolEstudianteService.eliminarRolEstudiante(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
