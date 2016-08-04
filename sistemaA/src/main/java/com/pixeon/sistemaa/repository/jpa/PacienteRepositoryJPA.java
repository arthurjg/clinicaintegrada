package com.pixeon.sistemaa.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.pixeon.sistemaa.model.Paciente;
import com.pixeon.sistemaa.repository.PacienteRepository;

public class PacienteRepositoryJPA implements PacienteRepository {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public String salvar(Paciente paciente) {
		manager.persist(paciente);
		return paciente.getCodigo();
	}

	@Override
	public Paciente buscar(Integer id) {
		String hql = "select p from Paciente p where p.id = :id";
		Query consulta = manager.createQuery(hql);
		consulta.setParameter("id", id );
		return (Paciente) consulta.getSingleResult();
	}

}
