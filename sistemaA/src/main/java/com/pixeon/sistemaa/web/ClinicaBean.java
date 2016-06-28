package com.pixeon.sistemaa.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import com.pixeon.sistemaa.model.Clinica;
import com.pixeon.sistemaa.model.ClinicaCliente;
import com.pixeon.sistemaa.model.ClinicaServicoX;
import com.pixeon.sistemaa.service.ClinicaService;
import com.pixeon.sistemaa.web.util.MensagemUtil;

@ManagedBean(name = "clinicaBean")
@RequestScoped
public class ClinicaBean {
	
	@Inject
	private ClinicaService clinicaService;	
	
	private Clinica clinica;
	private ClinicaServicoX clinicaServico;
	private ClinicaCliente clinicaCliente;
	private List<Clinica> clinicas;
	private List<ClinicaCliente> visualizadores;
	private Integer visualizadorCodigo;
	
	public ClinicaBean(){		
	}
	
	public ClinicaBean(ClinicaService clinicaService){
		this.clinicaService = clinicaService;
	}	
	
	@PostConstruct
	public void init(){
		clinica = new Clinica();
		clinicaServico = new ClinicaServicoX();
		clinicaCliente = new ClinicaCliente();
	}
	
	public String editar(){		
		return "clinica_edicao";
	}
	
	public String salvar(){			
		this.clinica.setClinicaServico(this.clinicaServico);
		
		ClinicaCliente visualizador = clinicaService.carregarVisualizador(visualizadorCodigo);
		this.clinica.setClinicaCliente(visualizador);				
		
		if(this.clinica.getId() == null || this.clinica.getId() == 0){			
			clinicaService.salvar(this.clinica);			
		} else {
			clinicaService.atualizar(this.clinica);
		}		
		MensagemUtil.adicionaMensagem("Clinica salva com sucesso.");
		return "clinicas?faces-redirect=true";
	}
	
	public String salvarCliente(){			
		this.clinica.setClinicaCliente(this.clinicaCliente);
		clinicaService.salvarCliente(clinica);		
		MensagemUtil.adicionaMensagem("Cliente/Visualizador da Clinica salvo com sucesso.");
		return "clinicas?faces-redirect=true";
	}
	
	public String excluir(){		
		clinicaService.remover(this.clinica);
		this.clinica = new Clinica();
		this.clinicas = null;
		MensagemUtil.adicionaMensagem("Clinica removida com sucesso.");		
		return null;
	}
	
	public void listarClinicas(){		
		clinicas = clinicaService.listar();		
	}	
	
	public void listarVisualizadores(){		
		visualizadores = clinicaService.listarVisualizadores();		
	}	

	public List<Clinica> getClinicas() {	
		if(clinicas == null){
			listarClinicas();
		}
		return clinicas;
	}

	public void setClinicas(List<Clinica> clinicas) {
		this.clinicas = clinicas;
	}	
	
	public List<ClinicaCliente> getVisualizadores() {
		if(visualizadores == null){
			listarVisualizadores();
		}
		return visualizadores;
	}

	public void setVisualizadores(List<ClinicaCliente> visualizadores) {
		this.visualizadores = visualizadores;
	}

	public Clinica getClinica() {
		return clinica;
	}

	public void setClinica(Clinica clinica) {
		this.clinica = clinica;
	}

	public ClinicaServicoX getClinicaServico() {
		return clinicaServico;
	}

	public void setClinicaServico(ClinicaServicoX clinicaServico) {
		this.clinicaServico = clinicaServico;
	}

	public ClinicaCliente getClinicaCliente() {
		return clinicaCliente;
	}

	public void setClinicaCliente(ClinicaCliente clinicaCliente) {
		this.clinicaCliente = clinicaCliente;
	}

	public Integer getVisualizadorCodigo() {
		return visualizadorCodigo;
	}

	public void setVisualizadorCodigo(Integer visualizadorCodigo) {
		this.visualizadorCodigo = visualizadorCodigo;
	}	
	
}
