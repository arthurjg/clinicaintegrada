package com.pixeon.sistemaa.repository;

import java.util.List;

import com.pixeon.sistemaa.model.Clinica;
import com.pixeon.sistemaa.model.ClinicaCliente;
import com.pixeon.sistemaa.model.ClinicaServicoX;

public interface ClinicaRepository {	
	
	public void salvar(Clinica clinica);
	public void atualizar(Clinica clinica);
	public void remover(Clinica clinica);
	public void salvarServico(ClinicaServicoX clinicaServico);
	public void removerServico(ClinicaServicoX clinicaServico);
	public void salvarCliente(ClinicaCliente clinicaCliente);
	public List<Clinica> listar();	
	public List<ClinicaCliente> listarVisualizadores();
	public ClinicaCliente carregarVisualizador(Integer codigo);
	public void atualizarServico(ClinicaServicoX clinicaServico);

}
