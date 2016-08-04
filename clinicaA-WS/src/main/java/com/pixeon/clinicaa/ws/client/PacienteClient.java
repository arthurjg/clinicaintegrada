package com.pixeon.clinicaa.ws.client;

import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.pixeon.clinicaa.model.PacienteX;
import com.pixeon.clinicaa.ws.client.util.RestClientUtil;

public class PacienteClient {
	
private Client client;
	
	@Inject
	public PacienteClient(){
		client = ClientBuilder.newClient();	
	}
	
	public void exportarPaciente(PacienteX paciente){		
		String dominio = "localhost";
		String porta = "8080";
		String contexto = "sistemaA";
		String prefixo = "rest/";
		String recurso = "pacientes";
		String prerecurso = prefixo + recurso;
		String recusosContexto = RestClientUtil.montaCaminhoContexto(dominio, porta, contexto);
		Response resposta = RestClientUtil.executaRequisicaoPost(client, recusosContexto, 
				prerecurso, paciente, MediaType.APPLICATION_JSON);	
		if(resposta.getStatus() == 201){
			String location = resposta.getLocation().toString();
			
			System.out.println("**** location: " + resposta.getLocation().getPath());
			System.out.println("**** location h: " + resposta.getHeaders().get("Location") );
			String id = RestClientUtil.extraiIdString(location, recurso);
			System.out.println("**** id: " + id);			
		}
	}	

}
