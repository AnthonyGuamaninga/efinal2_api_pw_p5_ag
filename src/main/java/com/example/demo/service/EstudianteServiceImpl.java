package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepo;
import com.example.demo.repository.model.Estudiante;
import com.example.demo.service.to.EstudianteTo;

@Service
public class EstudianteServiceImpl implements IEstudianteService{

	@Autowired
	private IEstudianteRepo estudianteRepo;
	
	@Override
	public void ingresar(EstudianteTo estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepo.insertar(this.parceToEstu(estudiante));
	}

	@Override
	public void modificar(EstudianteTo estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepo.actualizar(this.parceToEstu(estudiante));
	}

	@Override
	public void modificarParcial(Integer id, String nombre) {
		// TODO Auto-generated method stub
		this.estudianteRepo.actualizarParcial(id, nombre);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.estudianteRepo.eliminar(id);
	}

	@Override
	public EstudianteTo obtener(Integer id) {
		// TODO Auto-generated method stub
		EstudianteTo estudianteTo =convertToEstuTO(this.estudianteRepo.buscar(id));
		return estudianteTo;
	}
	
	@Override
	public List<EstudianteTo> buscarTodosLigeroTO() {
		// TODO Auto-generated method stub
		List<Estudiante> lista = this.estudianteRepo.buscarEstudiantes();
		List<EstudianteTo> listaFinal = new ArrayList<>();
		//listaFinal = lista.forEach(lst -> convertir(lst));
		for(Estudiante e : lista) {
			listaFinal.add(this.convertToEstuTO(e));
		}
		return listaFinal;
	}
	
	
	private Estudiante parceToEstu(EstudianteTo to) {
		Estudiante estu = new Estudiante();
		estu.setApellido(to.getApellido());
		estu.setNombre(to.getNombre());
		estu.setId(to.getId());
		estu.setCedula(to.getCedula());
		return estu;
	}
	
	private EstudianteTo convertToEstuTO(Estudiante e) {
		EstudianteTo estudianteTo = new EstudianteTo();
		estudianteTo.setId(e.getId());
		estudianteTo.setNombre(e.getNombre());
		estudianteTo.setApellido(e.getApellido());
		estudianteTo.setCedula(e.getCedula());
		return estudianteTo;
	}

}
