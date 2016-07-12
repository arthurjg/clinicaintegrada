package com.pixeon.clinicaa.service;

import java.util.List;

import com.pixeon.clinicaa.model.Clinica;

public interface ClinicaService {
	
	public void salvar(Clinica clinica);
	public void atualizar(Clinica clinica);
	public void remover(Clinica clinica);	
	public Clinica carregar(Integer id);
	public List<Clinica> listar();	

}
