package com.pixeon.sistemaa.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import com.pixeon.sistemaa.model.ClinicaCliente;
import com.pixeon.sistemaa.model.ClinicaServicoX;
import com.pixeon.sistemaa.model.Exame;
import com.pixeon.sistemaa.model.Paciente;
import com.pixeon.sistemaa.service.ExameService;
import com.pixeon.sistemaa.web.util.MensagemUtil;
import com.pixeon.sistemaa.web.util.URLConfigUtil;

@ManagedBean(name = "exameBean")
@ViewScoped
public class ExameBean {
	
	@Inject
	private ExameService exameService;	
	
	private Exame exameSelecionado = new Exame();
	private Integer codigoPaciente;
	private List<Exame> examesDoPaciente;	
	
	public ExameBean(){		
	}
	
	public ExameBean(ExameService exameService){
		this.exameService = exameService;
	}
	
	public void buscarExamesPorPaciente(){
		Paciente paciente = new Paciente();		
		paciente.setId(this.codigoPaciente);
		examesDoPaciente = exameService.buscarExamesPorPaciente(paciente);		
	}
	
	public void visualizaImagem(){
		ClinicaServicoX servico = exameSelecionado.getClinica().getClinicaServico();
		ClinicaCliente visualizador = exameSelecionado.getClinica().getClinicaCliente();
		
		String caminhoVisualizadorImagem = 
				URLConfigUtil.montaContextoURL(visualizador.getDominio(), 
						visualizador.getPorta(), visualizador.getCaminhoContexto(), visualizador.getCaminhoVisualizador());
		
		Map<String, Object> parametros = this.carregaParametrosVisualizador(servico, visualizador, exameSelecionado);
		caminhoVisualizadorImagem += URLConfigUtil.montaParametrosURL(parametros);
		
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext(); 
		
		try {			
			context.redirect(caminhoVisualizadorImagem);
		} catch (IOException e){			
			MensagemUtil.adicionaMensagem("Houve um erro desconhecido ao redirecionar para a imagem.");
		}	
	}	
	
	private Map<String, Object> carregaParametrosVisualizador(ClinicaServicoX servico, 
			ClinicaCliente visualizador, Exame exame){
		
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put(visualizador.getDominioServicoParametro(), servico.getDominio());
		parametros.put(visualizador.getPortaServicoParametro(), servico.getPorta());
		parametros.put(visualizador.getContextoServicoParametro(), servico.getCaminhoContexto());
		parametros.put(visualizador.getRecursoServicoParametro(), servico.getCaminhoRecurso());
		parametros.put(visualizador.getPacienteParametroNome(), servico.getPacienteParametro());
		parametros.put(visualizador.getExameParametroNome(), servico.getExameParametro());
		parametros.put(visualizador.getPacienteParametroValor(), exame.getPaciente().getId());
		parametros.put(visualizador.getExameParametroValor(), exame.getId());	
		
		return parametros;
	}

	public List<Exame> getExamesDoPaciente() {
		if(codigoPaciente != null && examesDoPaciente == null){
			buscarExamesPorPaciente();
		}
		return examesDoPaciente;
	}

	public void setExamesDoPaciente(List<Exame> examesDoPaciente) {
		this.examesDoPaciente = examesDoPaciente;
	}

	public Integer getCodigoPaciente() {
		return codigoPaciente;
	}

	public void setCodigoPaciente(Integer codigoPaciente) {
		this.codigoPaciente = codigoPaciente;
	}

	public Exame getExameSelecionado() {
		return exameSelecionado;
	}

	public void setExameSelecionado(Exame exameSelecionado) {
		this.exameSelecionado = exameSelecionado;
	}
	
}
