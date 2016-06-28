package com.pixeon.clinica.visualizador.service.rn;

import java.io.InputStream;

import javax.inject.Inject;

import com.pixeon.clinica.visualizador.service.ExameImagemService;
import com.pixeon.clinica.visualizador.ws.client.ExameImagemClient;

public class ExameImagemServiceRN implements ExameImagemService {
	
	@Inject
	private ExameImagemClient exameImagemClient;

	@Override
	public InputStream buscaExameImagem(String dominio, String porta, String contexto, String recurso, 
			String pacienteParametro, String exameParametro, Integer codigoPaciente, Integer codigoExame) {
		
		return exameImagemClient.buscaExameImagem(dominio, porta, contexto, recurso,
				pacienteParametro, exameParametro, codigoPaciente, codigoExame);
	}

}
