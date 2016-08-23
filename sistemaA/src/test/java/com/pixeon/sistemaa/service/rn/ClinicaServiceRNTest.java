package com.pixeon.sistemaa.service.rn;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.pixeon.sistemaa.model.Clinica;
import com.pixeon.sistemaa.model.ClinicaCliente;
import com.pixeon.sistemaa.model.ClinicaServicoX;
import com.pixeon.sistemaa.repository.ClinicaRepository;
import com.pixeon.sistemaa.repository.jpa.ClinicaRepositoryJPA;
import com.pixeon.sistemaa.service.ClinicaService;

public class ClinicaServiceRNTest {
	
	private ClinicaService clinicaService;
	private ClinicaRepository clinicaRepository;	

	@Before
	public void setUp() throws Exception {
		clinicaRepository = mock(ClinicaRepositoryJPA.class);
		clinicaService = new ClinicaServiceRN(clinicaRepository);	
	}

	@Test
	public void testListar() {
		// montando cenario
		Clinica clinicaA = new Clinica();
		Clinica clinicaB = new Clinica();		
		String nomeA = "Clinica A";
		String nomeB = "Clinica B";
		int codigoA = 9999;
		int codigoB = 8888;
		clinicaA.setId(codigoA);
		clinicaB.setId(codigoB);
		clinicaA.setNome(nomeA);
		clinicaB.setNome(nomeB);		

		List<Clinica> clinicas = new ArrayList<Clinica>();
		clinicas.add(clinicaA);
		clinicas.add(clinicaB);

		when(clinicaRepository.listar()).thenReturn(clinicas);

		// executando acao
		List<Clinica> clinicasTest = clinicaService.listar();

		// validando saida
		Assert.assertEquals(clinicas.size(), clinicasTest.size(), 0);
		Assert.assertEquals(clinicas.get(0).getId(), clinicasTest.get(0).getId());
		Assert.assertEquals(clinicas.get(1).getNome(), clinicasTest.get(1).getNome());
	}

	@Test
	public void testSalvar() {
		// montando cenario
		Clinica clinica = new Clinica();		
		String login = "Clinica A";
		clinica.setNome(login);		
		ClinicaServicoX servico = new ClinicaServicoX();
		clinica.setClinicaServico(servico);
		
		// executando acao
		clinicaService.salvar(clinica);
		
		// validando saida		
		verify(clinicaRepository).salvar(clinica);			
		verify(clinicaRepository).salvarServico(servico);		
	}

	@Test
	public void testAtualizar() {
		// montando cenario
		Clinica clinica = new Clinica();
		String login = "Clinica A";
		clinica.setId(999);
		clinica.setNome(login);
		ClinicaServicoX servico = new ClinicaServicoX();
		servico.setId(555);
		clinica.setClinicaServico(servico);

		// executando acao
		clinicaService.atualizar(clinica);

		// validando saida
		verify(clinicaRepository).atualizar(clinica);
		verify(clinicaRepository).atualizarServico(servico);
	}

	@Test
	public void testSalvarCliente() {
		// montando cenario
		Clinica clinica = new Clinica();
		String login = "Clinica A";
		clinica.setNome(login);
		ClinicaCliente cliente = new ClinicaCliente();
		clinica.setClinicaCliente(cliente);

		// executando acao
		clinicaService.salvarCliente(clinica);

		// validando saida		
		verify(clinicaRepository).salvarCliente(clinica.getClinicaCliente());
	}

	@Test
	public void testListarVisualizadores() {
		// montando cenario
		ClinicaCliente clinicaClienteA = new ClinicaCliente();
		ClinicaCliente clinicaClienteB = new ClinicaCliente();
		String nomeA = "ClinicaCliente A";
		String nomeB = "ClinicaCliente B";
		int codigoA = 9999;
		int codigoB = 8888;
		clinicaClienteA.setId(codigoA);
		clinicaClienteB.setId(codigoB);
		clinicaClienteA.setDominio(nomeA);
		clinicaClienteB.setDominio(nomeB);

		List<ClinicaCliente> clinicaClientes = new ArrayList<ClinicaCliente>();
		clinicaClientes.add(clinicaClienteA);
		clinicaClientes.add(clinicaClienteB);

		when(clinicaRepository.listarVisualizadores()).thenReturn(clinicaClientes);

		// executando acao
		List<ClinicaCliente> clinicaClientesTest = clinicaService.listarVisualizadores();

		// validando saida
		Assert.assertEquals(clinicaClientes.size(), clinicaClientesTest.size(), 0);
		Assert.assertEquals(clinicaClientes.get(0).getId(), clinicaClientesTest.get(0).getId());
		Assert.assertEquals(clinicaClientes.get(1).getDominio(), clinicaClientesTest.get(1).getDominio());
	}

	@Test
	public void testCarregarVisualizador() {
		// montando cenario
		ClinicaCliente clinicaClienteMock = new ClinicaCliente();
		ClinicaCliente clinicaCliente = new ClinicaCliente();
		String login = "ClinicaCliente A";
		int codigo = 9999;
		clinicaClienteMock.setDominio(login);
		clinicaClienteMock.setId(codigo);

		when(clinicaRepository.carregarVisualizador(codigo)).thenReturn(clinicaClienteMock);

		// executando acao
		clinicaCliente = clinicaService.carregarVisualizador(codigo);

		// validando saida
		Assert.assertEquals(clinicaCliente.getId(), clinicaClienteMock.getId());
		Assert.assertEquals(clinicaCliente.getDominio(), clinicaClienteMock.getDominio());
	}

	@Test
	public void testRemover() {
		// montando cenario
		Clinica clinica = new Clinica();
		String login = "Clinica A";
		clinica.setNome(login);
		ClinicaServicoX servico = new ClinicaServicoX();
		clinica.setClinicaServico(servico);

		// executando acao
		clinicaService.remover(clinica);

		// validando saida
		verify(clinicaRepository).remover(clinica);
		verify(clinicaRepository).removerServico(servico);
	}

}
