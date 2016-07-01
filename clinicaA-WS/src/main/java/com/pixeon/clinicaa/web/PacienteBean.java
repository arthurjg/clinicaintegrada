package com.pixeon.clinicaa.web;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import com.pixeon.clinicaa.model.Paciente;
import com.pixeon.clinicaa.service.PacienteService;
import com.pixeon.clinicaa.web.util.MensagemUtil;

@ManagedBean(name = "pacienteBean")
@RequestScoped
public class PacienteBean {
	
	@Inject
	private PacienteService pacienteService;
	
	@Inject
	private MensagemUtil mensagemUtil;
	
	private Paciente paciente = new Paciente();
	private List<Paciente> pacientes;

	public PacienteBean() {			
	}
	
	public PacienteBean(PacienteService pacienteService) {		
		this.pacienteService = pacienteService;
	}

	public String salvar(){						
		
		if(this.paciente.getId() == null || this.paciente.getId() == 0){			
			pacienteService.salvar(this.paciente);			
		} else {
			pacienteService.atualizar(this.paciente);
		}		
		mensagemUtil.adicionaMensagem("Paciente salvo com sucesso.");
		limparView();
		return "pacientes?faces-redirect=true";
	}
	
	public String excluir(){
		pacienteService.remover(this.paciente);
		mensagemUtil.adicionaMensagem("Paciente " + this.paciente.getNome() + " removido com sucesso.");
		limparView();
		return "pacientes?faces-redirect=true";
	}
	
	public void listar(){
		this.pacientes = pacienteService.listar();
	}
	
	private void limparView(){
		this.paciente = new Paciente();
		this.pacientes = null;
		
	}
	
	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public List<Paciente> getPacientes() {
		if(pacientes == null){
			listar();
		}
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

}
