package com.pixeon.clinicaa.service.rn;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.pixeon.clinicaa.model.Paciente;
import com.pixeon.clinicaa.model.PacienteX;
import com.pixeon.clinicaa.repository.PacienteRepository;
import com.pixeon.clinicaa.service.PacienteService;
import com.pixeon.clinicaa.ws.client.PacienteClient;

public class PacienteServiceRN implements PacienteService {
	
	@Inject
	private PacienteRepository pacienteRepository;
	
	@Inject
	private PacienteClient pacienteClient;

	@Override
	@Transactional
	public void salvar(Paciente paciente) {
		pacienteRepository.salvar(paciente);
	}

	@Override
	@Transactional
	public void atualizar(Paciente paciente) {
		pacienteRepository.atualizar(paciente);
	}

	@Override
	@Transactional
	public void remover(Paciente paciente) {
		pacienteRepository.remover(paciente);
	}

	@Override
	@Transactional
	public List<Paciente> listar() {		
		return pacienteRepository.listar();
	}

	@Override
	public Paciente carregar(Integer id) {		
		return pacienteRepository.carregar(id);
	}

	@Override
	public void exportar(Paciente paciente) {
		PacienteX pacienteX = new PacienteX(paciente);
		pacienteClient.exportarPaciente(pacienteX);		
	}

}
