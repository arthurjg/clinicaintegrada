package com.pixeon.sistemaa.service;

import java.util.List;

import com.pixeon.sistemaa.model.Exame;
import com.pixeon.sistemaa.model.Paciente;

public interface ExameService {
	
	public List<Exame> buscarExamesPorPaciente(Paciente paciente);
	public List<Exame> buscarExamesPorPacienteId(Integer pacienteId);

}
