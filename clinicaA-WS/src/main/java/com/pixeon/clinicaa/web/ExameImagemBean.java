package com.pixeon.clinicaa.web;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.Part;

import com.pixeon.clinicaa.model.Clinica;
import com.pixeon.clinicaa.model.Exame;
import com.pixeon.clinicaa.model.Paciente;
import com.pixeon.clinicaa.service.ClinicaService;
import com.pixeon.clinicaa.service.ExameImagemService;
import com.pixeon.clinicaa.service.PacienteService;
import com.pixeon.clinicaa.web.util.FileSaver;
import com.pixeon.clinicaa.web.util.MensagemUtil;

@ManagedBean(name = "exameImagemBean")
@RequestScoped
public class ExameImagemBean {
	
	@Inject
	private ExameImagemService exameImagemService;
	
	@Inject
	private ClinicaService clinicaService;
	
	@Inject
	private PacienteService pacienteService;
	
	@Inject
	private FileSaver fileSaver;
	
	@Inject
	private MensagemUtil mensagemUtil;
	
	private Exame exame = new Exame();
	private Part imagem;	
	private List<Clinica> clinicas;
	private List<Paciente> pacientes;
	
	public ExameImagemBean(){
		
	}
	
	public String salvar(){
		if(imagem != null){
			String imagemCaminho = fileSaver.writeOnExternal("exames", imagem);
			exame.setImagemCaminho(imagemCaminho);
		}		
		exameImagemService.salvar(exame);
		mensagemUtil.adicionaMensagem("exame salvo com sucesso.");
		limparDados();
		return "exames?faces-redirect=true";
	}
	
	private void limparDados(){
		this.exame = new Exame();
	}

	public Exame getExame() {
		return exame;
	}

	public void setExame(Exame exame) {
		this.exame = exame;
	}

	public Part getImagem() {
		return imagem;
	}

	public void setImagem(Part imagem) {
		this.imagem = imagem;
	}

	public List<Clinica> getClinicas() {
		if(clinicas == null){
			clinicas = clinicaService.listar();
		}
		return clinicas;
	}

	public void setClinicas(List<Clinica> clinicas) {
		this.clinicas = clinicas;
	}

	public List<Paciente> getPacientes() {
		if(pacientes == null){
			pacientes = pacienteService.listar();
		}
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

}
