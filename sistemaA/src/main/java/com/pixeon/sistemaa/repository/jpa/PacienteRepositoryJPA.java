package com.pixeon.sistemaa.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

}
