package com.pixeon.clinicaa.model;

import java.util.Date;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "exame")
public class Exame {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	
	private String codigoExterno;
	private String nome;		
	private String solicitante;
	private String analise;
	private String conclusao;
	private String imagemCaminho;
	private Date dataRealizacao;
	private Date dataResultado;	
	private boolean exportado;
	
	
	@ManyToOne
	@NotNull
	private Clinica clinica;
	
	@ManyToOne
	@NotNull
	private Paciente paciente;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}	

	public String getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}

	public String getAnalise() {
		return analise;
	}

	public void setAnalise(String analise) {
		this.analise = analise;
	}

	public String getConclusao() {
		return conclusao;
	}

	public void setConclusao(String conclusao) {
		this.conclusao = conclusao;
	}

	public Clinica getClinica() {
		return clinica;
	}

	public void setClinica(Clinica clinica) {
		this.clinica = clinica;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	public String getImagemCaminho() {
		return imagemCaminho;
	}

	public void setImagemCaminho(String imagemCaminho) {
		this.imagemCaminho = imagemCaminho;
	}

	public Date getDataRealizacao() {
		return dataRealizacao;
	}

	public void setDataRealizacao(Date dataRealizacao) {
		this.dataRealizacao = dataRealizacao;
	}

	public Date getDataResultado() {
		return dataResultado;
	}

	public void setDataResultado(Date dataResultado) {
		this.dataResultado = dataResultado;
	}

	public boolean isExportado() {
		return exportado;
	}
	
	public boolean getExportado() {
		return exportado;
	}

	public void setExportado(boolean exportado) {
		this.exportado = exportado;
	}

	public String getCodigoExterno() {
		return codigoExterno;
	}

	public void setCodigoExterno(String codigoExterno) {
		this.codigoExterno = codigoExterno;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((analise == null) ? 0 : analise.hashCode());
		result = prime * result + ((clinica == null) ? 0 : clinica.hashCode());
		result = prime * result
				+ ((codigoExterno == null) ? 0 : codigoExterno.hashCode());
		result = prime * result
				+ ((conclusao == null) ? 0 : conclusao.hashCode());
		result = prime * result
				+ ((dataRealizacao == null) ? 0 : dataRealizacao.hashCode());
		result = prime * result
				+ ((dataResultado == null) ? 0 : dataResultado.hashCode());
		result = prime * result + (exportado ? 1231 : 1237);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((imagemCaminho == null) ? 0 : imagemCaminho.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result
				+ ((paciente == null) ? 0 : paciente.hashCode());
		result = prime * result
				+ ((solicitante == null) ? 0 : solicitante.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Exame other = (Exame) obj;
		if (analise == null) {
			if (other.analise != null)
				return false;
		} else if (!analise.equals(other.analise))
			return false;
		if (clinica == null) {
			if (other.clinica != null)
				return false;
		} else if (!clinica.equals(other.clinica))
			return false;
		if (codigoExterno == null) {
			if (other.codigoExterno != null)
				return false;
		} else if (!codigoExterno.equals(other.codigoExterno))
			return false;
		if (conclusao == null) {
			if (other.conclusao != null)
				return false;
		} else if (!conclusao.equals(other.conclusao))
			return false;
		if (dataRealizacao == null) {
			if (other.dataRealizacao != null)
				return false;
		} else if (!dataRealizacao.equals(other.dataRealizacao))
			return false;
		if (dataResultado == null) {
			if (other.dataResultado != null)
				return false;
		} else if (!dataResultado.equals(other.dataResultado))
			return false;
		if (exportado != other.exportado)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (imagemCaminho == null) {
			if (other.imagemCaminho != null)
				return false;
		} else if (!imagemCaminho.equals(other.imagemCaminho))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (paciente == null) {
			if (other.paciente != null)
				return false;
		} else if (!paciente.equals(other.paciente))
			return false;
		if (solicitante == null) {
			if (other.solicitante != null)
				return false;
		} else if (!solicitante.equals(other.solicitante))
			return false;
		return true;
	}	

}
