package com.pixeon.sistemaa.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.pixeon.sistemaa.model.Clinica;
import com.pixeon.sistemaa.model.ClinicaCliente;
import com.pixeon.sistemaa.model.ClinicaServicoX;
import com.pixeon.sistemaa.repository.ClinicaRepository;

public class ClinicaRepositoryJPA implements ClinicaRepository {
	
	@PersistenceContext
	private EntityManager manager;
	
	public ClinicaRepositoryJPA(){
		
	}
	
	public ClinicaRepositoryJPA(EntityManager manager){
		this.manager = manager;
	}	

	@Override
	public List<Clinica> listar() {
		String hql = "select c from Clinica c";
		Query consulta = manager.createQuery(hql);		
		return consulta.getResultList();
	}

	@Override
	public void salvar(Clinica clinica) {
		manager.persist(clinica);		
	}

	@Override
	public void atualizar(Clinica clinica) {
		manager.merge(clinica);		
	}

	@Override
	public void salvarServico(ClinicaServicoX clinicaServico) {				
		manager.persist(clinicaServico);		
	}

	@Override
	public void salvarCliente(ClinicaCliente clinicaCliente) {
		manager.persist(clinicaCliente);		
	}

	@Override
	public List<ClinicaCliente> listarVisualizadores() {
		String hql = "select c from ClinicaCliente c";
		Query consulta = manager.createQuery(hql);		
		return consulta.getResultList();
	}

	@Override
	public ClinicaCliente carregarVisualizador(Integer codigo) {
		return (ClinicaCliente) manager.find(ClinicaCliente.class, codigo);
	}

	@Override
	public void atualizarServico(ClinicaServicoX clinicaServico) {
		manager.merge(clinicaServico);				
	}

	@Override
	public void remover(Clinica clinica) {		
		clinica = manager.find(Clinica.class, clinica.getId());
		manager.remove(clinica);		
	}

	@Override
	public void removerServico(ClinicaServicoX clinicaServico) {
		clinicaServico = manager.find(ClinicaServicoX.class, clinicaServico.getId());
		manager.remove(clinicaServico);			
	}

}
