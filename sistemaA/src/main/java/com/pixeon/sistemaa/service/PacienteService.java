package com.pixeon.sistemaa.service;

import com.pixeon.sistemaa.model.Paciente;

public interface PacienteService {	
	
	public String salvar(Paciente paciente);
	public Paciente buscar(Integer id);

}
