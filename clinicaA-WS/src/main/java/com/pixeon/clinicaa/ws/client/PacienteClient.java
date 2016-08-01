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
		String recurso = "rest/pacientes";
		String recusosContexto = RestClientUtil.montaCaminhoContexto(dominio, porta, contexto);
		Response resposta = RestClientUtil.executaRequisicaoPost(client, recusosContexto, 
				recurso, paciente, MediaType.APPLICATION_JSON);				
	}	

}
