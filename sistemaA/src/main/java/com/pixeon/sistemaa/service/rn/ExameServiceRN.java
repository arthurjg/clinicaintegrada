package com.pixeon.sistemaa.service.rn;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.pixeon.sistemaa.model.Exame;
import com.pixeon.sistemaa.model.Paciente;
import com.pixeon.sistemaa.repository.ExameRepository;
import com.pixeon.sistemaa.service.ExameService;

public class ExameServiceRN implements ExameService {
	
	@Inject
	private ExameRepository exameRepository;
	
	public ExameServiceRN(){
		
	}
	
	public ExameServiceRN(ExameRepository exameRepository){
		this.exameRepository = exameRepository;
	}

	@Override
	@Transactional
	public List<Exame> buscarExamesPorPaciente(Paciente paciente) {		
		return exameRepository.buscarExamesPorPaciente(paciente);
	}

	@Override
	public List<Exame> buscarExamesPorPacienteId(Integer pacienteId) {
		return exameRepository.buscarExamesPorPacienteId(pacienteId);
	}

}
