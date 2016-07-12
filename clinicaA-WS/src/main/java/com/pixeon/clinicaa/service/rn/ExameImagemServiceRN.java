package com.pixeon.clinicaa.service.rn;

import java.io.InputStream;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.pixeon.clinicaa.model.Clinica;
import com.pixeon.clinicaa.model.Exame;
import com.pixeon.clinicaa.model.Paciente;
import com.pixeon.clinicaa.repository.ExameImagemRepository;
import com.pixeon.clinicaa.repository.ExameRepository;
import com.pixeon.clinicaa.service.ExameImagemService;

public class ExameImagemServiceRN implements ExameImagemService {
	
	@Inject
	private ExameImagemRepository exameImagemRepository;
	
	@Inject
	private ExameRepository exameRepository;

	@Override
	public InputStream buscaExameImagem(Integer codigoPaciente, Integer codigoExame) throws Exception {		
		return exameImagemRepository.buscaExameImagem(codigoPaciente, codigoExame);
	}

	@Override
	@Transactional
	public void salvar(Exame exame) {
		exameRepository.salvar(exame);		
	}

	@Override
	public List<Exame> listarPorClinicaEPaciente(Clinica clinica, Paciente paciente) {		
		return exameRepository.listarPorClinicaEPaciente(clinica, paciente);
	}	

}
