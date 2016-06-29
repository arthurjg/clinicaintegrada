package com.pixeon.clinicaa.service;

import java.io.InputStream;

import com.pixeon.clinicaa.model.Exame;

public interface ExameImagemService {
	
	public InputStream buscaExameImagem(Integer codigoPaciente, Integer codigoExame) throws Exception;
	public void salvar(Exame exame);

}
