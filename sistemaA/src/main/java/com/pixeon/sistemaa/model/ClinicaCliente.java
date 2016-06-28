package com.pixeon.sistemaa.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.pixeon.sistemaa.web.util.URLConfigUtil;

@Entity
@Table(name = "clinica_cliente")
public class ClinicaCliente implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	
	
	private String dominio;
	private String porta;
	private String caminhoContexto;
	private String caminhoVisualizador;
	
	private String dominioServicoParametro;
	private String portaServicoParametro;		
	private String contextoServicoParametro;	
	private String recursoServicoParametro;
	private String pacienteParametroNome;
	private String exameParametroNome;
	private String pacienteParametroValor;
	private String exameParametroValor;
	
	public String getCaminhoBase() {
		return URLConfigUtil.montaContextoURL(dominio, porta, caminhoContexto, caminhoVisualizador);
	}
	
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
	public String getCaminhoVisualizador() {
		return caminhoVisualizador;
	}
	public void setCaminhoVisualizador(String caminhoVisualizador) {
		this.caminhoVisualizador = caminhoVisualizador;
	}
	public String getDominioServicoParametro() {
		return dominioServicoParametro;
	}
	public void setDominioServicoParametro(String dominioServicoParametro) {
		this.dominioServicoParametro = dominioServicoParametro;
	}
	public String getPortaServicoParametro() {
		return portaServicoParametro;
	}
	public void setPortaServicoParametro(String portaServicoParametro) {
		this.portaServicoParametro = portaServicoParametro;
	}
	public String getContextoServicoParametro() {
		return contextoServicoParametro;
	}
	public void setContextoServicoParametro(String contextoServicoParametro) {
		this.contextoServicoParametro = contextoServicoParametro;
	}
	public String getRecursoServicoParametro() {
		return recursoServicoParametro;
	}
	public void setRecursoServicoParametro(String recursoServicoParametro) {
		this.recursoServicoParametro = recursoServicoParametro;
	}
	public String getPacienteParametroNome() {
		return pacienteParametroNome;
	}
	public void setPacienteParametroNome(String pacienteParametroNome) {
		this.pacienteParametroNome = pacienteParametroNome;
	}
	public String getExameParametroNome() {
		return exameParametroNome;
	}
	public void setExameParametroNome(String exameParametroNome) {
		this.exameParametroNome = exameParametroNome;
	}
	public String getPacienteParametroValor() {
		return pacienteParametroValor;
	}
	public void setPacienteParametroValor(String pacienteParametroValor) {
		this.pacienteParametroValor = pacienteParametroValor;
	}
	public String getExameParametroValor() {
		return exameParametroValor;
	}
	public void setExameParametroValor(String exameParametroValor) {
		this.exameParametroValor = exameParametroValor;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((caminhoContexto == null) ? 0 : caminhoContexto.hashCode());
		result = prime
				* result
				+ ((caminhoVisualizador == null) ? 0 : caminhoVisualizador
						.hashCode());
		result = prime
				* result
				+ ((contextoServicoParametro == null) ? 0
						: contextoServicoParametro.hashCode());
		result = prime * result + ((dominio == null) ? 0 : dominio.hashCode());
		result = prime
				* result
				+ ((dominioServicoParametro == null) ? 0
						: dominioServicoParametro.hashCode());
		result = prime
				* result
				+ ((exameParametroNome == null) ? 0 : exameParametroNome
						.hashCode());
		result = prime
				* result
				+ ((exameParametroValor == null) ? 0 : exameParametroValor
						.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime
				* result
				+ ((pacienteParametroNome == null) ? 0 : pacienteParametroNome
						.hashCode());
		result = prime
				* result
				+ ((pacienteParametroValor == null) ? 0
						: pacienteParametroValor.hashCode());
		result = prime * result + ((porta == null) ? 0 : porta.hashCode());
		result = prime
				* result
				+ ((portaServicoParametro == null) ? 0 : portaServicoParametro
						.hashCode());
		result = prime
				* result
				+ ((recursoServicoParametro == null) ? 0
						: recursoServicoParametro.hashCode());
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
		ClinicaCliente other = (ClinicaCliente) obj;
		if (caminhoContexto == null) {
			if (other.caminhoContexto != null)
				return false;
		} else if (!caminhoContexto.equals(other.caminhoContexto))
			return false;
		if (caminhoVisualizador == null) {
			if (other.caminhoVisualizador != null)
				return false;
		} else if (!caminhoVisualizador.equals(other.caminhoVisualizador))
			return false;
		if (contextoServicoParametro == null) {
			if (other.contextoServicoParametro != null)
				return false;
		} else if (!contextoServicoParametro
				.equals(other.contextoServicoParametro))
			return false;
		if (dominio == null) {
			if (other.dominio != null)
				return false;
		} else if (!dominio.equals(other.dominio))
			return false;
		if (dominioServicoParametro == null) {
			if (other.dominioServicoParametro != null)
				return false;
		} else if (!dominioServicoParametro
				.equals(other.dominioServicoParametro))
			return false;
		if (exameParametroNome == null) {
			if (other.exameParametroNome != null)
				return false;
		} else if (!exameParametroNome.equals(other.exameParametroNome))
			return false;
		if (exameParametroValor == null) {
			if (other.exameParametroValor != null)
				return false;
		} else if (!exameParametroValor.equals(other.exameParametroValor))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (pacienteParametroNome == null) {
			if (other.pacienteParametroNome != null)
				return false;
		} else if (!pacienteParametroNome.equals(other.pacienteParametroNome))
			return false;
		if (pacienteParametroValor == null) {
			if (other.pacienteParametroValor != null)
				return false;
		} else if (!pacienteParametroValor.equals(other.pacienteParametroValor))
			return false;
		if (porta == null) {
			if (other.porta != null)
				return false;
		} else if (!porta.equals(other.porta))
			return false;
		if (portaServicoParametro == null) {
			if (other.portaServicoParametro != null)
				return false;
		} else if (!portaServicoParametro.equals(other.portaServicoParametro))
			return false;
		if (recursoServicoParametro == null) {
			if (other.recursoServicoParametro != null)
				return false;
		} else if (!recursoServicoParametro
				.equals(other.recursoServicoParametro))
			return false;
		return true;
	}	

}
