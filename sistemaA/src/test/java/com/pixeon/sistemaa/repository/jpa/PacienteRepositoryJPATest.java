package com.pixeon.sistemaa.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.pixeon.sistemaa.model.Paciente;
import com.pixeon.sistemaa.repository.PacienteRepository;

public class PacienteRepositoryJPATest {

	private PacienteRepository pacienteRepository;

	private static EntityManagerFactory entityManagerFactory;
	
	private EntityManager manager;
	
	@BeforeClass
	public static void setUpBeforeClass(){
		entityManagerFactory = Persistence.createEntityManagerFactory("sistemaATestPU");
	}
	
	@Before
	public void setUp() {		
		this.manager = entityManagerFactory.createEntityManager();
		pacienteRepository = new PacienteRepositoryJPA(manager);
	}

	@Test
	public void testSalvar() {
		//montando cenario		
		String nome = "John_Smith";
		String endereco = "Av Brasil";
		Paciente paciente = new Paciente();
		paciente.setNome(nome);
		paciente.setEndereco(endereco);
				
		//executando acao		
		this.manager.getTransaction().begin();
		pacienteRepository.salvar(paciente);
		this.manager.getTransaction().commit();
				
		//validando saida				
		Assert.assertNotNull(paciente.getId());
				
	}

}
