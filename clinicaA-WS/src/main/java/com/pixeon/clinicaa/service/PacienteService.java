package com.pixeon.clinicaa.service;

import java.util.List;

import com.pixeon.clinicaa.model.Paciente;

public interface PacienteService {
	
	public void salvar(Paciente paciente);
	public void atualizar(Paciente paciente);
	public void remover(Paciente paciente);	
	public Paciente carregar(Integer id);
	public List<Paciente> listar();	
	public void exportar(Paciente paciente);

}
