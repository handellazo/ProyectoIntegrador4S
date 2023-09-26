package pe.edu.upeu.proyInt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upeu.proyInt.entity.ProyectoEntity;
import pe.edu.upeu.proyInt.service.ProyectoService;

import java.util.List;
    @RestController
    @RequestMapping("/api/PROYECTO")
    public class ProyectoController {
        @Autowired
        private ProyectoService proyectoService;

        @GetMapping("/listarProyecto")
        public ResponseEntity<List<ProyectoEntity>> listaProyectos(){
            List<ProyectoEntity> proyectos = proyectoService.proyectoListar();
            return new ResponseEntity<>(proyectos, HttpStatus.OK);
        };
    }

