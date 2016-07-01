package com.pixeon.clinicaa.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.pixeon.clinicaa.model.Paciente;
import com.pixeon.clinicaa.repository.PacienteRepository;

public class PacienteRepositoryJPA implements PacienteRepository {

	@PersistenceContext
	private EntityManager manager;
	
	public PacienteRepositoryJPA(){
		
	}
	
	public PacienteRepositoryJPA(EntityManager manager){
		this.manager = manager;
	}	

	@Override
	public List<Paciente> listar() {
		String hql = "select p from Paciente p";
		Query consulta = manager.createQuery(hql);		
		return consulta.getResultList();
	}

	@Override
	public void salvar(Paciente paciente) {
		manager.persist(paciente);		
	}

	@Override
	public void atualizar(Paciente paciente) {
		manager.merge(paciente);		
	}

	@Override
	public void remover(Paciente paciente) {
		paciente = manager.find(Paciente.class, paciente.getId());
		if(paciente != null){
			manager.remove(paciente);
		}		
	}	

}
