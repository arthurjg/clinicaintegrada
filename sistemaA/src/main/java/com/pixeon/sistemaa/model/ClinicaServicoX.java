package com.pixeon.sistemaa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clinica_servico")
public class ClinicaServicoX {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	
	
	private String dominio;
	private String porta;
	private String caminhoContexto;
	private String caminhoRecurso;
	private String pacienteParametro;
	private String exameParametro;	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDominio() {
		return dominio;
	}
	public void setDominio(String dominio) {
		this.dominio = dominio;
	}
	public String getPorta() {
		return porta;
	}
	public void setPorta(String porta) {
		this.porta = porta;
	}
	public String getCaminhoContexto() {
		return caminhoContexto;
	}
	public void setCaminhoContexto(String caminhoContexto) {
		this.caminhoContexto = caminhoContexto;
	}
	public String getCaminhoRecurso() {
		return caminhoRecurso;
	}
	public void setCaminhoRecurso(String caminhoRecurso) {
		this.caminhoRecurso = caminhoRecurso;
	}
	public String getPacienteParametro() {
		return pacienteParametro;
	}
	public void setPacienteParametro(String pacienteParametro) {
		this.pacienteParametro = pacienteParametro;
	}
	public String getExameParametro() {
		return exameParametro;
	}
	public void setExameParametro(String exameParametro) {
		this.exameParametro = exameParametro;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((caminhoContexto == null) ? 0 : caminhoContexto.hashCode());
		result = prime * result
				+ ((caminhoRecurso == null) ? 0 : caminhoRecurso.hashCode());
		result = prime * result + ((dominio == null) ? 0 : dominio.hashCode());
		result = prime * result
				+ ((exameParametro == null) ? 0 : exameParametro.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime
				* result
				+ ((pacienteParametro == null) ? 0 : pacienteParametro
						.hashCode());
		result = prime * result + ((porta == null) ? 0 : porta.hashCode());
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
		ClinicaServicoX other = (ClinicaServicoX) obj;
		if (caminhoContexto == null) {
			if (other.caminhoContexto != null)
				return false;
		} else if (!caminhoContexto.equals(other.caminhoContexto))
			return false;
		if (caminhoRecurso == null) {
			if (other.caminhoRecurso != null)
				return false;
		} else if (!caminhoRecurso.equals(other.caminhoRecurso))
			return false;
		if (dominio == null) {
			if (other.dominio != null)
				return false;
		} else if (!dominio.equals(other.dominio))
			return false;
		if (exameParametro == null) {
			if (other.exameParametro != null)
				return false;
		} else if (!exameParametro.equals(other.exameParametro))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (pacienteParametro == null) {
			if (other.pacienteParametro != null)
				return false;
		} else if (!pacienteParametro.equals(other.pacienteParametro))
			return false;
		if (porta == null) {
			if (other.porta != null)
				return false;
		} else if (!porta.equals(other.porta))
			return false;
		return true;
	}	

}
