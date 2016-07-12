package com.pixeon.clinicaa.service.rn;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.pixeon.clinicaa.model.Clinica;
import com.pixeon.clinicaa.repository.ClinicaRepository;
import com.pixeon.clinicaa.service.ClinicaService;

public class ClinicaServiceRN implements ClinicaService {
	
	@Inject
	private ClinicaRepository clinicaRepository;

	@Override
	@Transactional
	public void salvar(Clinica clinica) {
		clinicaRepository.salvar(clinica);
	}

	@Override
	@Transactional
	public void atualizar(Clinica clinica) {
		clinicaRepository.atualizar(clinica);
	}

	@Override
	@Transactional
	public void remover(Clinica clinica) {
		clinicaRepository.remover(clinica);
	}

	@Override
	@Transactional
	public List<Clinica> listar() {		
		return clinicaRepository.listar();
	}

	@Override
	public Clinica carregar(Integer id) {		
		return clinicaRepository.carregar(id);
	}

}
