package com.pixeon.clinicaa.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.pixeon.clinicaa.model.Clinica;
import com.pixeon.clinicaa.model.Exame;
import com.pixeon.clinicaa.model.Paciente;
import com.pixeon.clinicaa.repository.ExameRepository;

public class ExameRepositoryJPA implements ExameRepository {
	
	@PersistenceContext
	private EntityManager manager;
	
	public ExameRepositoryJPA(){		
	}
	
	public ExameRepositoryJPA(EntityManager manager){
		this.manager = manager;
	}

	@Override
	public void salvar(Exame exame) {
		manager.persist(exame);		
	}

	@Override
	public List<Exame> listarPorClinicaEPaciente(Clinica clinica, Paciente paciente) {
		
		CriteriaBuilder criteria = manager.getCriteriaBuilder(); 
		CriteriaQuery<Exame> criteriaQuery = criteria.createQuery(Exame.class);
		Root<Exame> root = criteriaQuery.from(Exame.class);
		criteriaQuery.select(root);	
		
		if (clinica != null && clinica != null){
			Predicate predicate = criteria.and(
					criteria.equal(root.get("clinica"), clinica),
					criteria.equal(root.get("paciente"), paciente));		
			
			criteriaQuery.where(predicate);
		}
		
		TypedQuery<Exame> query = manager.createQuery(criteriaQuery);
		List<Exame> exames = query.getResultList();	
		return exames;
	}

}
