package pe.edu.upeu.proyInt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.proyInt.dto.ProyectoDto;
import pe.edu.upeu.proyInt.entity.PersonaEntity;
import pe.edu.upeu.proyInt.entity.ProyectoEntity;
import pe.edu.upeu.proyInt.service.ProyectoService;

import java.util.List;
    @RestController
    @RequestMapping("/api/PROYECTO")
    @CrossOrigin({"*"})
    public class ProyectoController {
        @Autowired
        private ProyectoService proyectoService;

        @GetMapping("/listarProyecto")
        public ResponseEntity<List<ProyectoEntity>> listaProyectos(){
            List<ProyectoEntity> proyectos = proyectoService.proyectoListar();
            return new ResponseEntity<>(proyectos, HttpStatus.OK);
        };

        @PostMapping("/addProyecto") //POST @PostMapping es una anotacion para construir APIS
        public ResponseEntity<ProyectoEntity> crearProyecto(@RequestBody ProyectoDto proyecto) {
            try{
            ProyectoEntity newProyecto = proyectoService.guardarProyecto(proyecto);
            if (newProyecto != null) {
                return new ResponseEntity<>(newProyecto, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            } catch (Error e){
                System.out.println("Error pe mongol: " + e);
            }
            return null;
        }
    }

