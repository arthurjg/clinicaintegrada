package com.pixeon.sistemaa.ws.rest;

import java.net.URI;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.pixeon.sistemaa.model.Paciente;
import com.pixeon.sistemaa.service.PacienteService;

@Path("/pacientes")
public class PacienteResource {
	
	@Inject
	private PacienteService pacienteService;
	
	@POST	
	public Response adicionar(Paciente paciente){
		
		try {
			pacienteService.salvar(paciente);	
			System.out.println("**********************Paciente exportado!!!");
			URI pacientesUri = new URI("/pacientes/" + paciente.getId().toString());
			return Response.status(201).contentLocation(pacientesUri).build();
		} catch(Exception exception){
			return Response.status(500).entity(exception.getMessage()).build();
		}
	}

}
