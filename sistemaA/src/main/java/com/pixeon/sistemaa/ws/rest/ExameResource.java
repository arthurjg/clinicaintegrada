package com.pixeon.sistemaa.ws.rest;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.pixeon.sistemaa.model.Exame;
import com.pixeon.sistemaa.service.ExameService;

@Path("/exames")
public class ExameResource {
	
	@Inject
	private ExameService exameService;
	
	@POST	
	public Response adicionar(Exame exame){
		
		try {
			//exameService.salvar(exame);	
			System.out.println("**********************Exame exportado!!!");
			return Response.status(200).build();
		} catch(Exception exception){
			return Response.status(500).entity(exception.getMessage()).build();
		}
	}

}
