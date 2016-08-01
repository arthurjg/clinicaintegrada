package com.pixeon.sistemaa.web;

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
import com.pixeon.sistemaa.service.ClinicaService;
import com.pixeon.sistemaa.service.rn.ClinicaServiceRN;
import com.pixeon.sistemaa.web.util.MensagemUtil;

public class ClinicaBeanTest {
	
	private ClinicaBean clinicaBean;
	private ClinicaService clinicaService;		

	@Before
	public void setUp() throws Exception {
		clinicaService = mock(ClinicaServiceRN.class);
		MensagemUtil mensagemUtil = mock(MensagemUtil.class);	
		clinicaBean = new ClinicaBean(clinicaService, mensagemUtil);
	}

	@Test
	public void testSalvar() {
		// montando cenario
		Clinica clinica = new Clinica();		
		String nomeA = "Clinica A";		
				
		clinica.setNome(nomeA);		
		clinica.prePersist();	
		
		clinicaBean.init();
		clinicaBean.setVisualizadorCodigo(1);
		clinicaBean.setClinica(clinica);
		
		ClinicaCliente visualizador = new ClinicaCliente();
		
		when(clinicaService.carregarVisualizador(clinicaBean.getVisualizadorCodigo()))
			.thenReturn(visualizador);
		
		// executando acao
		clinicaBean.salvar();		
		
		// validando resultado
		verify(clinicaService).salvar(clinica);			
	}

	@Test
	public void testSalvarCliente() {
		// montando cenario
		clinicaBean.init();			

		// executando acao
		clinicaBean.salvarCliente();

		// validando resultado
		verify(clinicaService).salvarCliente(clinicaBean.getClinica());
	}

	@Test
	public void testExcluir() {
		// montando cenario
		clinicaBean.init();		
		Clinica clinica = new Clinica();		
		String nomeA = "Clinica A";					
		clinica.setNome(nomeA);		
		clinicaBean.setClinica(clinica);
		
		clinicaBean.excluir();
				
		verify(clinicaService).remover(clinica);			
	}

	@Test
	public void testListarClinicas() {
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
		clinicaA.prePersist();
		clinicaB.prePersist();		

		List<Clinica> clinicas = new ArrayList<Clinica>();
		clinicas.add(clinicaA);
		clinicas.add(clinicaB);

		when(clinicaService.listar()).thenReturn(clinicas);

		// executando acao
		clinicaBean.listarClinicas();
		List<Clinica> clinicasTest = clinicaBean.getClinicas();

		// validando saida
		Assert.assertEquals(clinicas.size(), clinicasTest.size(), 0);
		Assert.assertEquals(clinicas.get(0).getId(), clinicasTest.get(0).getId());
		Assert.assertEquals(clinicas.get(1).getNome(), clinicasTest.get(1).getNome());
	}

	@Test
	public void testListarVisualizadores() {
		// montando cenario
		ClinicaCliente visualizadorA = new ClinicaCliente();
		ClinicaCliente visualizadorB = new ClinicaCliente();

		String dominioA = "ClinicaCliente A";
		String dominioB = "ClinicaCliente B";
		int codigoA = 9999;
		int codigoB = 8888;
		visualizadorA.setId(codigoA);
		visualizadorB.setId(codigoB);
		visualizadorA.setDominio(dominioA);
		visualizadorB.setDominio(dominioB);
		visualizadorA.setPorta("9090");
		visualizadorB.setPorta("9999");

		List<ClinicaCliente> visualizadores = new ArrayList<ClinicaCliente>();
		visualizadores.add(visualizadorA);
		visualizadores.add(visualizadorB);

		when(clinicaService.listarVisualizadores()).thenReturn(visualizadores);

		// executando acao
		clinicaBean.listarVisualizadores();
		List<ClinicaCliente> visualizadoresTest = clinicaBean.getVisualizadores();

		// validando saida
		Assert.assertEquals(visualizadores.size(), visualizadoresTest.size(), 0);
		Assert.assertEquals(visualizadores.get(0).getId(), visualizadoresTest.get(0).getId());
		Assert.assertEquals(visualizadores.get(1).getDominio(), visualizadoresTest.get(1).getDominio());
		Assert.assertEquals(visualizadores.get(1).getPorta(), visualizadoresTest.get(1).getPorta());
	}

}
