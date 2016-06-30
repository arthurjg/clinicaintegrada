package com.pixeon.clinicaa.repository;

import java.util.List;

import com.pixeon.clinicaa.model.Clinica;

public interface ClinicaRepository {
	
	public void salvar(Clinica clinica);
	public void atualizar(Clinica clinica);
	public void remover(Clinica clinica);	
	public List<Clinica> listar();	

}
