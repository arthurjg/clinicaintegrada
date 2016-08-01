package com.pixeon.clinicaa.ws.client;

import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.pixeon.clinicaa.model.Exame;
import com.pixeon.clinicaa.ws.client.util.RestClientUtil;

public class ExameClient {
	
	private Client client;
	
	@Inject
	public ExameClient(){
		client = ClientBuilder.newClient();	
	}
	
	public void exportarExame(Exame exame){		
		String dominio = "localhost";
		String porta = "8080";
		String contexto = "sistemaA";
		String recurso = "rest/exames";
		String recusosContexto = RestClientUtil.montaCaminhoContexto(dominio, porta, contexto);
		Response resposta = RestClientUtil.executaRequisicaoPost(client, recusosContexto, 
				recurso, exame, MediaType.APPLICATION_JSON);				
	}	

}
