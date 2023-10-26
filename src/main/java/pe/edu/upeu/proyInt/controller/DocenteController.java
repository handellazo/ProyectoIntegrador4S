package pe.edu.upeu.proyInt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.proyInt.entity.DocenteEntity;
import pe.edu.upeu.proyInt.service.DocenteService;

import java.util.List;

@RestController
@RequestMapping("/api/DOCENTE")
public class DocenteController {
    @Autowired
    private DocenteService docenteService;

    @GetMapping("/listDocente") //GET
    public ResponseEntity<List<DocenteEntity>> listaDocentes(){
        List<DocenteEntity> docentes = docenteService.docenteListar();
        return new ResponseEntity<>(docentes, HttpStatus.OK);
    };

    @PostMapping("/addDocente") //POST
    public ResponseEntity<DocenteEntity> crearDocente(@RequestBody DocenteEntity docente) {
        DocenteEntity newDocente = docenteService.guardarDocente(docente);
        if (newDocente != null) {
            return new ResponseEntity<>(newDocente, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateDocente/{id}") //PUT
    public ResponseEntity<DocenteEntity> updateDocente(@PathVariable Integer id, @RequestBody DocenteEntity newDocente) {
        DocenteEntity updateDocente = docenteService.editarDocente(id,newDocente);
        if (updateDocente != null) {
            return new ResponseEntity<>(updateDocente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteDocente/{id}") //DELETE
    public ResponseEntity<Void> deleteDocente(@PathVariable Integer id) {
        docenteService.eliminarDocente(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
