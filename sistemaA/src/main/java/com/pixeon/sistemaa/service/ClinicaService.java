package com.pixeon.sistemaa.service;

import java.util.List;

import com.pixeon.sistemaa.model.Clinica;
import com.pixeon.sistemaa.model.ClinicaCliente;

public interface ClinicaService {	
	
	public void salvar(Clinica clinica);
	public void atualizar(Clinica clinica);	
	public void remover(Clinica clinica);
	public void salvarCliente(Clinica clinica);
	public List<Clinica> listar();
	public List<ClinicaCliente> listarVisualizadores();
	public ClinicaCliente carregarVisualizador(Integer codigo);

}
