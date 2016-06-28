package com.pixeon.sistemaa.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.pixeon.sistemaa.model.Exame;
import com.pixeon.sistemaa.model.Paciente;
import com.pixeon.sistemaa.repository.ExameRepository;

public class ExameRepositoryJPATest {
	
	private ExameRepository exameRepository;

	private static EntityManagerFactory entityManagerFactory;
	
	private EntityManager manager;
	
	@BeforeClass
	public static void setUpBeforeClass(){
		entityManagerFactory = Persistence.createEntityManagerFactory("sistemaATestPU");
	}
	
	@Before
	public void setUp() {		
		this.manager = entityManagerFactory.createEntityManager();
		exameRepository = new ExameRepositoryJPA(manager);
	}

	@Test
	public void testBuscarExamesPorPaciente() {
		// montando cenario
		Integer codigoPaciente = 1;
		Paciente paciente = new Paciente();
		paciente.setId(codigoPaciente);
		
		// executando acao
		this.manager.getTransaction().begin();
		List<Exame> examesPaciente = exameRepository.buscarExamesPorPaciente(paciente);
		this.manager.getTransaction().commit();
		
		// validando saida
		Assert.assertNotNull(examesPaciente);
		Assert.assertEquals(2, examesPaciente.size());
		Assert.assertEquals(examesPaciente.get(0).getId(), 1, 0);
		Assert.assertEquals(examesPaciente.get(1).getId(), 2, 0);		
	}

}
