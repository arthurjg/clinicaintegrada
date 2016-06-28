package com.pixeon.clinica.visualizador.web;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

@ManagedBean(name = "visualizadorExameBean")
@RequestScoped
public class VisualizadorExameBean {
	
	@Inject
	private HttpServletRequest request;
	
	private String dominioRest;
	private String contextoRest;	
	private String portaRest;
	private String recursoRest;
	private String pacienteParametro;
	private String exameParametro;
	private Integer pacienteCodigo;
	private Integer exameCodigo;		

	public String getContextoRest() {
		contextoRest = request.getParameter("contextoRest");
		return contextoRest;
	}

	public void setContextoRest(String contextoRest) {
		this.contextoRest = contextoRest;
	}

	public String getDominioRest() {
		dominioRest = request.getParameter("dominioRest");
		return dominioRest;
	}

	public void setDominioRest(String dominioRest) {
		this.dominioRest = dominioRest;
	}

	public String getPortaRest() {
		portaRest = request.getParameter("portaRest");
		return portaRest;
	}

	public void setPortaRest(String portaRest) {
		this.portaRest = portaRest;
	}

	public String getRecursoRest() {
		recursoRest = request.getParameter("recursoRest");
		return recursoRest;
	}

	public void setRecursoRest(String recursoRest) {
		this.recursoRest = recursoRest;
	}

	public String getPacienteParametro() {
		pacienteParametro = request.getParameter("pacienteParametro");
		return pacienteParametro;
	}

	public void setPacienteParametro(String pacienteParametro) {
		this.pacienteParametro = pacienteParametro;
	}

	public String getExameParametro() {
		exameParametro = request.getParameter("exameParametro");
		return exameParametro;
	}

	public void setExameParametro(String exameParametro) {
		this.exameParametro = exameParametro;
	}

	public Integer getPacienteCodigo() {		
		String pacienteCodigoValor = request.getParameter("pacienteCodigo");
		if (pacienteCodigoValor != null) {
			pacienteCodigo = Integer.parseInt(pacienteCodigoValor);			
		}		
		return pacienteCodigo;
	}

	public void setPacienteCodigo(Integer pacienteCodigo) {
		this.pacienteCodigo = pacienteCodigo;
	}

	public Integer getExameCodigo() {				
		String exameCodigoValor = request.getParameter("exameCodigo");
		if (exameCodigoValor != null) {
			exameCodigo = Integer.parseInt(exameCodigoValor);			
		}
		return exameCodigo;
	}

	public void setExameCodigo(Integer exameCodigo) {
		this.exameCodigo = exameCodigo;
	}

}
