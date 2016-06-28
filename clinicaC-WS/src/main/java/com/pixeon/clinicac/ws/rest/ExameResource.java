package com.pixeon.clinicac.ws.rest;

import java.io.InputStream;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.pixeon.clinicac.service.ExameService;

@Path("/exames")
public class ExameResource {
	
	@Inject
	private ExameService exameService;
	
	@GET	
	@Produces( {MediaType.MEDIA_TYPE_WILDCARD} )
	@Path("/codigo/{pacienteCodigo}/{exameCodigo}")
	public Response buscaExameImagem(
			@PathParam(value = "pacienteCodigo") Integer paciente,
			@PathParam(value = "exameCodigo") Integer exame){
		
		try {
			InputStream imagem = exameService.buscaExame(paciente, exame);
			return Response.status(200).entity(imagem).build();
		} catch(Exception exception){
			return Response.status(500). entity(exception.getMessage()).build();
		}
		
	}

}
