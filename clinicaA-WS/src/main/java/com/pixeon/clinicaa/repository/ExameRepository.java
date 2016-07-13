package com.pixeon.clinicaa.repository;

import java.util.List;

import com.pixeon.clinicaa.model.Clinica;
import com.pixeon.clinicaa.model.Exame;
import com.pixeon.clinicaa.model.Paciente;

public interface ExameRepository {
	
	public void salvar(Exame exame);
	public void atualizar(Exame exame);
	public void remover(Exame exame);
	public List<Exame> listarPorClinicaEPaciente(Clinica clinica, Paciente paciente);

}
