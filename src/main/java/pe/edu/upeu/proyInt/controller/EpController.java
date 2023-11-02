package pe.edu.upeu.proyInt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.proyInt.entity.EpEntity;
import pe.edu.upeu.proyInt.service.EpService;

import java.util.List;

@RestController
@RequestMapping("/api/EP")
@CrossOrigin({"*"})
public class EpController {
    @Autowired
    private EpService epService;

    @GetMapping("/listEp") //GET
    public ResponseEntity<List<EpEntity>> listaEps(){
        List<EpEntity> eps = epService.epListar();
        return new ResponseEntity<>(eps, HttpStatus.OK);
    };

    @PostMapping("/addEp") //POST
    public ResponseEntity<EpEntity> crearEp(@RequestBody EpEntity ep) {
        EpEntity newEp = epService.guardarEp(ep);
        if (newEp != null) {
            return new ResponseEntity<>(newEp, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateEp/{id}") //PUT
    public ResponseEntity<EpEntity> updateEp(@PathVariable Integer id, @RequestBody EpEntity newEp) {
        EpEntity updateEp = epService.editarEp(id,newEp);
        if (updateEp != null) {
            return new ResponseEntity<>(updateEp, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteEp/{id}") //DELETE
    public ResponseEntity<Void> deleteEp(@PathVariable Integer id) {
        epService.eliminarEp(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
