package com.pixeon.clinicaa.ws.client.util;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RestClientUtilTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testMontaCaminhoContexto() {
		fail("Not yet implemented");
	}

	@Test
	public void testExecutaRequisicaoPost() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testExtraiIdString() {
		String procurada = "/pacientes/123";
		String ignorada = "pacientes";
		String idEsperada = "123";
		String id = RestClientUtil.extraiIdString(procurada, ignorada);
		
		assertEquals(idEsperada, id);
	}

}
