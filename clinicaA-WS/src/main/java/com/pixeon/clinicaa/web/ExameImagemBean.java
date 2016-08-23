package com.pixeon.clinicaa.web;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.Part;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.ServerErrorException;

import org.apache.log4j.Logger;

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
	
	private Logger logger = Logger.getLogger(ExameImagemBean.class);
	
	private Exame exame = new Exame();
	private Part imagem;	
	private List<Exame> exames;
	private List<Clinica> clinicas;
	private List<Paciente> pacientes;
	private Integer clinicaId;
	private Integer pacienteId;
	
	public ExameImagemBean(){
		
	}
	
	public String salvar(){
		exame.setClinica(clinicaService.carregar(clinicaId));
		exame.setPaciente(pacienteService.carregar(pacienteId));
		if(imagem != null){
			String imagemPrefixo = "exames_";
			imagemPrefixo = exame.getClinica() == null ? "" : exame.getClinica().getNome();
			imagemPrefixo += "_";
			imagemPrefixo += exame.getPaciente() == null ? "" : exame.getPaciente().getNome();
			String imagemCaminho = fileSaver.writeOnExternal(imagemPrefixo, imagem);
			exame.setImagemCaminho(imagemCaminho);
		}		
		if(this.exame.getId() == null || this.exame.getId() == 0){			
			exameImagemService.salvar(this.exame);			
		} else {
			exameImagemService.atualizar(this.exame);
		}			
		mensagemUtil.adicionaMensagem("exame salvo com sucesso.");
		limparDados();
		return "exames?faces-redirect=true";
	}
	
	public String excluir(){
		exameImagemService.remover(this.exame);
		mensagemUtil.adicionaMensagem("Exame " + this.exame.getNome() + " removido com sucesso.");
		limparDados();
		return "exames?faces-redirect=true";
	}
	
	public void exportar(){
		logger.info("exportando exame...");
		if(this.exame.isExportado()){
			mensagemUtil.adicionaMensagem("Esse Exame já foi exportado.");
			logger.info("exame não exportado - Esse Exame já foi exportado.");
			return;
		}
		if(this.exame.getPaciente().getCodigoExterno() == null){
			try {
				logger.info("exportando paciente...");
				exportarPaciente(this.exame.getPaciente());
				logger.info("... paciente exportado.");
			} catch(NotFoundException exception) {
				mensagemUtil.adicionaMensagem("O sistema externo não está disponivel, tente mais tarde ou contate o administrador.");
				logger.error("exame não exportado... O sistema externo não está disponivel.");
				return;
			} catch(ServerErrorException exception) {
				exception.printStackTrace();
				mensagemUtil.adicionaMensagem("O sistema externo não conseguiu processar a solicitação, tente mais tarde ou contate o administrador.");
				logger.error("exame não exportado... O sistema externo não conseguiu processar a solicitação.");
				return;
			}			
		}
		if(this.exame.getClinica().getCodigoExterno() == null){
			mensagemUtil.adicionaMensagem("A clinica do Exame não está associada no sistema externo. Favor rever cadastro da clinica.");
			logger.error("exame não exportado... A clinica do Exame não está associada no sistema externo..");
			return;
		}
		exameImagemService.exportar(this.exame);
		mensagemUtil.adicionaMensagem("Exame " + this.exame.getNome() + " exportado com sucesso.");
		logger.info("... exame exportado.");
		limparDados();	
		
	}
	
	private List<Exame> listar(){
		Clinica clinica = null;
		Paciente paciente = null;
		if(clinicaId != null){
			clinica = clinicaService.carregar(clinicaId); 
		}
		if(pacienteId != null){
			paciente = pacienteService.carregar(pacienteId); 
		}		 
		return exameImagemService.listarPorClinicaEPaciente(clinica, paciente);
	}
	
	private void exportarPaciente(Paciente paciente){
		pacienteService.exportar(paciente);
	}
	
	private void limparDados(){
		this.exame = new Exame();
		exames = null;
	}
	
	public List<Exame> getExames() {
		if(exames == null){
			exames = listar();
		}
		return exames;
	}

	public void setExames(List<Exame> exames) {		
		this.exames = exames;
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

	public Integer getClinicaId() {
		return clinicaId;
	}

	public void setClinicaId(Integer clinicaId) {
		this.clinicaId = clinicaId;
	}

	public Integer getPacienteId() {
		return pacienteId;
	}

	public void setPacienteId(Integer pacienteId) {
		this.pacienteId = pacienteId;
	}	

}
