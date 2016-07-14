package com.pixeon.sistemaa.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.pixeon.sistemaa.model.Exame;
import com.pixeon.sistemaa.model.Paciente;
import com.pixeon.sistemaa.repository.ExameRepository;

public class ExameRepositoryJPA implements ExameRepository {
	
	@PersistenceContext
	private EntityManager manager;
	
	public ExameRepositoryJPA(){
		
	}
	
	public ExameRepositoryJPA(EntityManager manager){
		this.manager = manager;
	}
	
	@Override
	public List<Exame> buscarExamesPorPacienteId(Integer pacienteId) {
		String hql = "select e from Exame e where e.paciente = :paciente";
		Query consulta = manager.createQuery(hql);
		consulta.setParameter("paciente", pacienteId );
		return (List<Exame>) consulta.getResultList();
	}

	@Override
	public List<Exame> buscarExamesPorPaciente(Paciente paciente) {
		CriteriaBuilder criteria = manager.getCriteriaBuilder(); 
		CriteriaQuery<Exame> criteriaQuery = criteria.createQuery(Exame.class);
		Root<Exame> root = criteriaQuery.from(Exame.class);
		criteriaQuery.select(root);	
		
		Predicate predicate = criteria.equal(root.get("paciente"), paciente);		
		
		criteriaQuery.where(predicate);
		
		TypedQuery<Exame> query = manager.createQuery(criteriaQuery);
		List<Exame> exames = query.getResultList();	
		return exames;
	}

	@Override
	public void salvar(Exame exame) {		
		manager.persist(exame);
	}

}
