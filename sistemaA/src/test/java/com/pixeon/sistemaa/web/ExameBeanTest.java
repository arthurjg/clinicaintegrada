package com.pixeon.sistemaa.web;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.pixeon.sistemaa.model.Exame;
import com.pixeon.sistemaa.model.Paciente;
import com.pixeon.sistemaa.service.ExameService;
import com.pixeon.sistemaa.service.rn.ExameServiceRN;

public class ExameBeanTest {
	
	private ExameBean exameBean;
	private ExameService exameService;	

	@Before
	public void setUp() throws Exception {
		exameService = mock(ExameServiceRN.class);
		exameBean = new ExameBean(exameService);	
	}

	@Test
	public void testBuscarExamesPorPaciente() {
		// montando cenario
		Exame exameA = new Exame();
		Exame exameB = new Exame();
		exameBean.setCodigoPaciente(100);
		Paciente paciente = new Paciente();
		String nomeA = "Holter";
		String nomeB = "Tomografia";
		int codigoA = 9999;
		int codigoB = 8888;
		exameA.setId(codigoA);
		exameB.setId(codigoB);
		exameA.setNome(nomeA);
		exameB.setNome(nomeB);
		paciente.setId(exameBean.getCodigoPaciente());		

		List<Exame> exames = new ArrayList<Exame>();
		exames.add(exameA);
		exames.add(exameB);

		when(exameService.buscarExamesPorPaciente(paciente)).thenReturn(exames);

		// executando acao
		List<Exame> examesTest = exameBean.getExamesDoPaciente();

		// validando saida
		Assert.assertEquals(exames.size(), examesTest.size(), 0);
		Assert.assertEquals(exames.get(0).getId(), examesTest.get(0).getId());
		Assert.assertEquals(exames.get(1).getNome(), examesTest.get(1).getNome());
	}	

}
