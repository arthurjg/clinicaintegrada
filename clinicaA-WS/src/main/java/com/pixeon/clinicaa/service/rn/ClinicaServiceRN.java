package com.pixeon.clinicaa.service.rn;

import java.util.List;

import javax.inject.Inject;

import com.pixeon.clinicaa.model.Clinica;
import com.pixeon.clinicaa.repository.ClinicaRepository;
import com.pixeon.clinicaa.service.ClinicaService;

public class ClinicaServiceRN implements ClinicaService {
	
	@Inject
	private ClinicaRepository clinicaRepository;

	@Override
	public void salvar(Clinica clinica) {
		clinicaRepository.salvar(clinica);
	}

	@Override
	public void atualizar(Clinica clinica) {
		clinicaRepository.atualizar(clinica);
	}

	@Override
	public void remover(Clinica clinica) {
		clinicaRepository.remover(clinica);
	}

	@Override
	public List<Clinica> listar() {		
		return clinicaRepository.listar();
	}

}
