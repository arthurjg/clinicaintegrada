package com.pixeon.clinicaa.repository;

import java.util.List;

import com.pixeon.clinicaa.model.Paciente;

public interface PacienteRepository {
	
	public void salvar(Paciente paciente);
	public void atualizar(Paciente paciente);
	public void remover(Paciente paciente);	
	public List<Paciente> listar();	

}
