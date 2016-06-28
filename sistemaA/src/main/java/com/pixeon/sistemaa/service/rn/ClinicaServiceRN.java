package com.pixeon.sistemaa.service.rn;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.pixeon.sistemaa.model.Clinica;
import com.pixeon.sistemaa.model.ClinicaCliente;
import com.pixeon.sistemaa.repository.ClinicaRepository;
import com.pixeon.sistemaa.service.ClinicaService;

public class ClinicaServiceRN implements ClinicaService {
	
	@Inject
	private ClinicaRepository clinicaRepository;
	
	public ClinicaServiceRN(){
		
	}
	
	public ClinicaServiceRN(ClinicaRepository clinicaRepository){
		this.clinicaRepository = clinicaRepository;
	}

	@Override
	@Transactional
	public List<Clinica> listar() {		
		return clinicaRepository.listar();
	}

	@Override
	@Transactional
	public void salvar(Clinica clinica) {
		clinicaRepository.salvarServico(clinica.getClinicaServico());
		clinicaRepository.salvar(clinica);		
	}

	@Override
	@Transactional
	public void atualizar(Clinica clinica) {
		clinicaRepository.atualizarServico(clinica.getClinicaServico());
		clinicaRepository.atualizar(clinica);		
	}

	@Override
	@Transactional
	public void salvarCliente(Clinica clinica) {
		clinicaRepository.salvarCliente(clinica.getClinicaCliente());					
	}

	@Override
	@Transactional
	public List<ClinicaCliente> listarVisualizadores() {		
		return clinicaRepository.listarVisualizadores();
	}

	@Override
	@Transactional
	public ClinicaCliente carregarVisualizador(Integer codigo) {
		return clinicaRepository.carregarVisualizador(codigo);
	}

	@Override
	@Transactional
	public void remover(Clinica clinica) {
		clinicaRepository.remover(clinica);	
		clinicaRepository.removerServico(clinica.getClinicaServico());
	}	

}
