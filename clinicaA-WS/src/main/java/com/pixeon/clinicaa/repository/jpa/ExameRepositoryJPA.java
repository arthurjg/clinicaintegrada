package com.pixeon.clinicaa.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.pixeon.clinicaa.model.Exame;
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

}
