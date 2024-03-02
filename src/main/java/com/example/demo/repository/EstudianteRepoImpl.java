package com.example.demo.repository;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.model.Estudiante;

@Transactional
@Repository
public class EstudianteRepoImpl implements IEstudianteRepo{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.entityManager.persist(estudiante);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.entityManager.merge(estudiante);
	}

	@Override
	public void actualizarParcial(Integer id, String nombre) {
		// TODO Auto-generated method stub
		Query query = this.entityManager.createQuery("UPDATE e.estu_name= :nombre FROM e estudiante WHERE estu_id= :id ");
		query.setParameter("id", id);
		query.setParameter("nombre", nombre);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscar(id));
	}

	@Override
	public Estudiante buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Estudiante.class, id);
	}
	
	@Override
	public List<Estudiante> buscarEstudiantes() {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> query = this.entityManager.createQuery("SELECT e FROM Estudiante e", Estudiante.class);
		return query.getResultList();
	}

}
