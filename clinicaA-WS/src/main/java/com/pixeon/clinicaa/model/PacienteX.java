package com.pixeon.clinicaa.model;

public class PacienteX {
	
	private Integer id;	
	private String nome;
	private String endereco;	
	
	private String codigo;
	
	public PacienteX(){
		
	}

	public PacienteX(Paciente paciente){
		this.nome = paciente.getNome();
		this.endereco = paciente.getEndereco();
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}
