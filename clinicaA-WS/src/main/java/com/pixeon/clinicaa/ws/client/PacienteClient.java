package com.pixeon.clinicaa.ws.client;

import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.ServerErrorException;
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
	
	public Integer exportarPaciente(PacienteX paciente){		
		Integer pacienteCodigo = null;
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
			String locationPath = resposta.getLocation().getPath();
			System.out.println("location: " + locationPath);
			pacienteCodigo = this.buscarPacienteCodigo(locationPath);				
		}
		return pacienteCodigo;
	}	
	
	private Integer buscarPacienteCodigo(String locationPath){
		String dominio = "localhost";
		String porta = "8080";
		String contexto = "sistemaA";
		String prefixo = "rest/";
		String recurso = RestClientUtil.extraiSubString(locationPath, contexto);
		String prerecurso = prefixo + recurso;
		String recusosContexto = RestClientUtil.montaCaminhoContexto(dominio, porta, contexto);
		Response resposta = RestClientUtil.executaRequisicaoGet(client, recusosContexto, 
				prerecurso, MediaType.APPLICATION_JSON);
		System.out.println("rest get: " + prerecurso);
		System.out.println("rest get: " + recusosContexto + prerecurso);
		if(resposta.getStatus() == 200){
			PacienteX paciente = (PacienteX) resposta.getEntity();
			if(paciente != null && paciente.getId() != null){
				return paciente.getId();
			}			 
		}		
		if(resposta.getStatus() == 404){
			throw new NotFoundException();
		}
		if(resposta.getStatus() == 500){
			throw new ServerErrorException(resposta);
		}
		return null;
	}

}
