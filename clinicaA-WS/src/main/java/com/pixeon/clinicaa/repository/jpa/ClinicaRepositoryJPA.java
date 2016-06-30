package com.pixeon.clinicaa.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.pixeon.clinicaa.model.Clinica;
import com.pixeon.clinicaa.repository.ClinicaRepository;

public class ClinicaRepositoryJPA implements ClinicaRepository {

	@PersistenceContext
	private EntityManager manager;
	
	public ClinicaRepositoryJPA(){
		
	}
	
	public ClinicaRepositoryJPA(EntityManager manager){
		this.manager = manager;
	}	

	@Override
	public List<Clinica> listar() {
		String hql = "select c from Clinica c";
		Query consulta = manager.createQuery(hql);		
		return consulta.getResultList();
	}

	@Override
	public void salvar(Clinica clinica) {
		manager.persist(clinica);		
	}

	@Override
	public void atualizar(Clinica clinica) {
		manager.merge(clinica);		
	}

	@Override
	public void remover(Clinica clinica) {
		manager.remove(clinica);
	}	

}
