package com.pixeon.clinicaa.ws.rest;

import java.io.InputStream;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.pixeon.clinicaa.service.ExameImagemService;


@Path("/clinica/exames")
public class ExameImagemResource {
	
	@Inject
	private ExameImagemService exameImagemService;
	
	@GET
	@Path("/paciente/{paciente}/exame/{exame}")
	public Response buscaExameImagem(
			@PathParam(value = "paciente") Integer paciente,
			@PathParam(value = "exame") Integer exame){
		
		try {
			InputStream imagem = exameImagemService.buscaExameImagem(paciente, exame);			
			return Response.status(200).entity(imagem).build();
		} catch(Exception exception){
			return Response.status(500). entity(exception.getMessage()).build();
		}
	}

}
