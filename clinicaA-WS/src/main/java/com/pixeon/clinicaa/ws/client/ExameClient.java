package com.pixeon.clinicaa.ws.client;

import java.io.InputStream;

import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.pixeon.clinicaa.model.Exame;

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
		String recusosContexto = this.montaCaminhoContexto(dominio, porta, contexto);
		Response resposta = 
				executaRequisicaoAoRecurso(recusosContexto, recurso, exame, MediaType.APPLICATION_JSON);				
	}	

	private Response executaRequisicaoAoRecurso(String recusosContexto, 
			String recusosCaminho, Exame exame, String mediaType){		
		
		WebTarget webTarget = client.target(recusosContexto);		
		WebTarget resourceWebTarget = webTarget.path(recusosCaminho);	
		
		Invocation.Builder invocationBuilder =	resourceWebTarget.request(mediaType);	
		Entity<Exame> exameEntity = Entity.entity(exame, mediaType);
		
		return invocationBuilder.post(exameEntity);		
	}
	
	private String montaCaminhoContexto(String dominio, String porta, String contexto){
		porta = porta.equals(null) ? "" : ":" + porta;
		return "http://" + dominio + porta + "/" + contexto;
	}

}
