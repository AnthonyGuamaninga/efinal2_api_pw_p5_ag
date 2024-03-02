package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.model.Estudiante;

public interface IEstudianteRepo {
	
	public void insertar(Estudiante estudiante);
	public void actualizar(Estudiante estudiante);
	public void actualizarParcial(Integer id, String nombre);
	public void eliminar(Integer id);
	public Estudiante buscar(Integer id);
	
	public List<Estudiante> buscarEstudiantes();
	
	

}
