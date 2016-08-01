package com.pixeon.clinicaa.ws.client.util;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import com.pixeon.clinicaa.model.Exame;

public class RestClientUtil {
	
	public static String montaCaminhoContexto(String dominio, String porta, String contexto){
		porta = porta.equals(null) ? "" : ":" + porta;
		return "http://" + dominio + porta + "/" + contexto;
	}
	
	public static Response executaRequisicaoPost(Client client, String recusosContexto, String recusosCaminho,
			Object exame, String mediaType){		
		
		WebTarget webTarget = client.target(recusosContexto);		
		WebTarget resourceWebTarget = webTarget.path(recusosCaminho);	
		
		Invocation.Builder invocationBuilder =	resourceWebTarget.request(mediaType);	
		Entity<Object> exameEntity = Entity.entity(exame, mediaType);
		
		return invocationBuilder.post(exameEntity);		
	}	

}
