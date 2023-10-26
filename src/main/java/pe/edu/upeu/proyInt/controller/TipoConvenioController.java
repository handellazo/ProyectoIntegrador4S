package pe.edu.upeu.proyInt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.proyInt.entity.TipoConvenioEntity;
import pe.edu.upeu.proyInt.service.TipoConvenioService;

import java.util.List;

@RestController
@RequestMapping("/api/TIPOCONVENIO")
public class TipoConvenioController {
    @Autowired
    private TipoConvenioService tipoConvenioService;

    @GetMapping("/listTipoConvenio") //GET
    public ResponseEntity<List<TipoConvenioEntity>> listaTipoConvenios(){
        List<TipoConvenioEntity> tipoConvenios = tipoConvenioService.tipoConvenioListar();
        return new ResponseEntity<>(tipoConvenios, HttpStatus.OK);
    };

    @PostMapping("/addTipoConvenio") //POST
    public ResponseEntity<TipoConvenioEntity> crearTipoConvenio(@RequestBody TipoConvenioEntity tipoConvenio) {
        TipoConvenioEntity newTipoConvenio = tipoConvenioService.guardarTipoConvenio(tipoConvenio);
        if (newTipoConvenio != null) {
            return new ResponseEntity<>(newTipoConvenio, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateTipoConvenio/{id}") //PUT
    public ResponseEntity<TipoConvenioEntity> updateTipoConvenio(@PathVariable Integer id, @RequestBody TipoConvenioEntity newTipoConvenio) {
        TipoConvenioEntity updateTipoConvenio = tipoConvenioService.editarTipoConvenio(id,newTipoConvenio);
        if (updateTipoConvenio != null) {
            return new ResponseEntity<>(updateTipoConvenio, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteTipoConvenio/{id}") //DELETE
    public ResponseEntity<Void> deleteTipoConvenio(@PathVariable Integer id) {
        tipoConvenioService.eliminarTipoConvenio(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
