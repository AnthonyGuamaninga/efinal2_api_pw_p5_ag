package com.example.demo.service;

import java.util.List;

import com.example.demo.service.to.EstudianteTo;

public interface IEstudianteService {
	
	public void ingresar(EstudianteTo estudiante);
	public void modificar(EstudianteTo estudiante);
	
	public void modificarParcial(Integer id, String nombre);
	
	public void borrar(Integer id);
	public EstudianteTo obtener(Integer id);
	public List<EstudianteTo> buscarTodosLigeroTO();

}
