package com.pixeon.clinicaa.service;

import java.io.InputStream;
import java.util.List;

import com.pixeon.clinicaa.model.Clinica;
import com.pixeon.clinicaa.model.Exame;
import com.pixeon.clinicaa.model.Paciente;

public interface ExameImagemService {
	
	public InputStream buscaExameImagem(Integer codigoPaciente, Integer codigoExame) throws Exception;
	public void salvar(Exame exame);
	public List<Exame> listarPorClinicaEPaciente(Clinica clinica, Paciente paciente);

}
