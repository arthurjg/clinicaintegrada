package com.pixeon.sistemaa.ws.rest;

import java.net.URI;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import com.pixeon.sistemaa.model.Paciente;
import com.pixeon.sistemaa.service.PacienteService;

@Path("/pacientes")
public class PacienteResource {
	
	@Context 
	private UriInfo uriInfo;
	
	@Inject
	private PacienteService pacienteService;
	
	@POST	
	public Response adicionar(Paciente paciente){
		
		try {
			pacienteService.salvar(paciente);			
			System.out.println("**********************Paciente exportado!!!");			
			URI pacientesUri = uriInfo.getAbsolutePathBuilder().path("/{id}").build(paciente.getId());			
			return Response.created(pacientesUri).build();
		} catch(Exception exception){
			return Response.serverError().entity(exception.getMessage()).build();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response buscar(@PathParam("id") Integer id){
		
		try {
			Paciente paciente = pacienteService.buscar(id);	
			if(paciente != null){
				System.out.println("**********************Paciente exportado!!!");				
				return Response.ok(paciente).build();
			} else {
				return Response.status(Status.NOT_FOUND).build();
			}
			
		} catch(Exception exception){
			return Response.serverError().entity(exception.getMessage()).build();
		}
	}

}
