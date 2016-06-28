package com.pixeon.clinicab.ws.rest;

import java.io.InputStream;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.pixeon.clinicab.service.ImagemExameService;

@Path("/servico/exames")
public class ImagemExameResource {
	
	@Inject
	private ImagemExameService imagemExameService;
	
	@GET
	@Produces( "image/jpeg" )
	@Path("/paciente/exame/{paciente}/{exame}")
	public Response buscaExameImagem(
			@PathParam(value = "paciente") Integer paciente,
			@PathParam(value = "exame") Integer exame){
		
		try {
			InputStream imagem = imagemExameService.buscaImagemExame(paciente, exame);
			return Response.status(200).entity(imagem).build();
		} catch(Exception exception){
			return Response.status(500). entity(exception.getMessage()).build();
		}
	}

}
