package com.pixeon.sistemaa.repository;

import java.util.List;

import com.pixeon.sistemaa.model.Exame;
import com.pixeon.sistemaa.model.Paciente;

public interface ExameRepository {
	
	public List<Exame> buscarExamesPorPaciente(Paciente paciente);
	public List<Exame> buscarExamesPorPacienteId(Integer pacienteId);

}
