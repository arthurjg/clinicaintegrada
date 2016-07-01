package com.pixeon.clinicaa.web;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import com.pixeon.clinicaa.model.Clinica;
import com.pixeon.clinicaa.service.ClinicaService;
import com.pixeon.clinicaa.web.util.MensagemUtil;

@ManagedBean(name = "clinicaBean")
@RequestScoped
public class ClinicaBean {
	
	@Inject
	private ClinicaService clinicaService;
	
	@Inject
	private MensagemUtil mensagemUtil;
	
	private Clinica clinica = new Clinica();
	private List<Clinica> clinicas;

	public ClinicaBean() {			
	}
	
	public ClinicaBean(ClinicaService clinicaService) {		
		this.clinicaService = clinicaService;
	}

	public String salvar(){						
		
		if(this.clinica.getId() == null || this.clinica.getId() == 0){			
			clinicaService.salvar(this.clinica);			
		} else {
			clinicaService.atualizar(this.clinica);
		}		
		mensagemUtil.adicionaMensagem("Clinica salva com sucesso.");
		limparView();
		return "clinicas?faces-redirect=true";
	}
	
	public String excluir(){
		clinicaService.remover(this.clinica);
		mensagemUtil.adicionaMensagem("Clinica " + this.clinica.getNome() + " removida com sucesso.");
		limparView();
		return "clinicas?faces-redirect=true";
	}
	
	public void listar(){
		this.clinicas = clinicaService.listar();
	}
	
	private void limparView(){
		this.clinica = new Clinica();
		this.clinicas = null;
		
	}
	
	public Clinica getClinica() {
		return clinica;
	}

	public void setClinica(Clinica clinica) {
		this.clinica = clinica;
	}

	public List<Clinica> getClinicas() {
		if(clinicas == null){
			listar();
		}
		return clinicas;
	}

	public void setClinicas(List<Clinica> clinicas) {
		this.clinicas = clinicas;
	}

}
