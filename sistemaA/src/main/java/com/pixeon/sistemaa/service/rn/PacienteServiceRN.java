package com.pixeon.sistemaa.service.rn;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.pixeon.sistemaa.model.Paciente;
import com.pixeon.sistemaa.repository.PacienteRepository;
import com.pixeon.sistemaa.service.PacienteService;

public class PacienteServiceRN implements PacienteService {
	
	@Inject
	private PacienteRepository pacienteRepository;

	@Override
	@Transactional
	public String salvar(Paciente paciente) {
		return pacienteRepository.salvar(paciente);
	}

	@Override
	public Paciente buscar(Integer id) {		
		return pacienteRepository.buscar(id);
	}

}
