package com.pixeon.sistemaa.ws.rest;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.pixeon.sistemaa.model.Exame;
import com.pixeon.sistemaa.service.ExameService;

@Path("/exames")
public class ExameResource {
	
	@Inject
	private ExameService exameService;
	
	@Context 
	private UriInfo uriInfo;
	
	@POST	
	public Response adicionar(Exame exame){
		
		try {
			exameService.salvar(exame);	
			System.out.println("**********************Exame exportado!!!");
			//URI pacientesUri = uriInfo.getAbsolutePathBuilder().path("/{id}").build(exame.getId());			
			//return Response.created(pacientesUri).build();
			return Response.ok().build();
		} catch(Exception exception){
			return Response.serverError().entity(exception.getMessage()).build();
		}
	}

}
