package com.example.demo.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.IEstudianteService;
import com.example.demo.service.to.EstudianteTo;

@RestController
@RequestMapping(path = "/estudiantes")
@CrossOrigin
public class EstudianteControllerRestFul {
	
	@Autowired
	private IEstudianteService estudianteService;
	
	@GetMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<EstudianteTo> buscar(@PathVariable Integer id) {
		EstudianteTo estu = this.estudianteService.obtener(id);				
		return ResponseEntity.status(HttpStatus.OK).body(estu);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EstudianteTo>> consultarTodosHateoas() {
		List<EstudianteTo> lista = this.estudianteService.buscarTodosLigeroTO();
		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> guardar(@RequestBody EstudianteTo estudiante) {
		this.estudianteService.ingresar(estudiante);
		return ResponseEntity.status(HttpStatus.OK).body("Estudiante "+estudiante.getApellido()+" insertado con exito!");
	}

	
}
