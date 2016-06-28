package com.pixeon.clinica.visualizador.ws.client;

import java.io.InputStream;

import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class ExameImagemClient {
	
	private Client client;
	
	@Inject
	public ExameImagemClient(){
		client = ClientBuilder.newClient();	
	}
	
	public InputStream buscaExameImagem(String dominio, String porta, String contexto, String recurso, 
			String pacienteParametro, String exameParametro, Integer codigoPaciente, Integer codigoExame){
		
		String recusosContexto = this.montaCaminhoContexto(dominio, porta, contexto);
		Response resposta = executaRequisicaoAoRecurso(recusosContexto, recurso, "image/jpeg", 
				pacienteParametro, exameParametro, codigoPaciente, codigoExame);	
		
		InputStream exameImagem = resposta.readEntity(InputStream.class);	
		return exameImagem;
	}	

	private Response executaRequisicaoAoRecurso(String recusosContexto, String recusosCaminho, String mediaType,
			String pacienteParametro, String exameParametro, Integer codigoPaciente, Integer codigoExame){
		
		recusosCaminho = this.insereParametrosNaURI(recusosCaminho, pacienteParametro, codigoPaciente.toString());
		recusosCaminho = this.insereParametrosNaURI(recusosCaminho, exameParametro, codigoExame.toString());
		
		WebTarget webTarget = client.target(recusosContexto);		
		WebTarget resourceWebTarget = webTarget.path(recusosCaminho);	
		
		Invocation.Builder invocationBuilder =	resourceWebTarget.request(mediaType);			
		
		return invocationBuilder.get();		
	}
	
	private String montaCaminhoContexto(String dominio, String porta, String contexto){
		porta = porta.equals(null) ? "" : ":" + porta;
		return "http://" + dominio + porta + "/" + contexto;
	}
	
	private String insereParametrosNaURI(String uri, String parametroNome, String parametroValor){
		uri = uri.replace("{" + parametroNome + "}", parametroValor);
		return uri;
	}	

}
