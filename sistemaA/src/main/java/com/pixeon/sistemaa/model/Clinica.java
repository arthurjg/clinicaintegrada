package com.pixeon.sistemaa.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "clinica")
public class Clinica {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	
	
	@Column(unique = true)
	private String codigo;
	
	private String nome;
	private String endereco;	
	
	@OneToOne
	@OnDelete(action=OnDeleteAction.CASCADE)
	private ClinicaServicoX clinicaServico;
	
	@ManyToOne
	private ClinicaCliente clinicaCliente;	
	
	@PrePersist
	public void prePersist(){
		this.codigo = UUID.randomUUID().toString();
	}
	
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
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
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
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((clinicaCliente == null) ? 0 : clinicaCliente.hashCode());
		result = prime * result
				+ ((clinicaServico == null) ? 0 : clinicaServico.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result
				+ ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Clinica other = (Clinica) obj;
		if (clinicaCliente == null) {
			if (other.clinicaCliente != null)
				return false;
		} else if (!clinicaCliente.equals(other.clinicaCliente))
			return false;
		if (clinicaServico == null) {
			if (other.clinicaServico != null)
				return false;
		} else if (!clinicaServico.equals(other.clinicaServico))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}		

}
