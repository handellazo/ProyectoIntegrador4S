package pe.edu.upeu.proyInt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.proyInt.entity.TipoPYEntity;
import pe.edu.upeu.proyInt.service.TipoPYService;

import java.util.List;

@RestController
@RequestMapping("/api/TIPOPY")
public class TipoPyController {
    @Autowired
    private TipoPYService tipoPyService;

    @GetMapping("/listTipoPy") //GET
    public ResponseEntity<List<TipoPYEntity>> listaTipoPys(){
        List<TipoPYEntity> tipoPys = tipoPyService.tipoPyListar();
        return new ResponseEntity<>(tipoPys, HttpStatus.OK);
    };

    @PostMapping("/addTipoPy") //POST
    public ResponseEntity<TipoPYEntity> crearTipoPy(@RequestBody TipoPYEntity tipoPy) {
        TipoPYEntity newTipoPy = tipoPyService.guardarTipoPy(tipoPy);
        if (newTipoPy != null) {
            return new ResponseEntity<>(newTipoPy, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateTipoPy/{id}") //PUT
    public ResponseEntity<TipoPYEntity> updateTipoPy(@PathVariable Integer id, @RequestBody TipoPYEntity newTipoPy) {
        TipoPYEntity updateTipoPy = tipoPyService.editarTipoPy(id,newTipoPy);
        if (updateTipoPy != null) {
            return new ResponseEntity<>(updateTipoPy, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteTipoPy/{id}") //DELETE
    public ResponseEntity<Void> deleteTipoPy(@PathVariable Integer id) {
        tipoPyService.eliminarTipoPy(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
