package com.pixeon.clinicaa.service;

import java.io.InputStream;

public interface ExameImagemService {
	
	public InputStream buscaExameImagem(Integer codigoPaciente, Integer codigoExame) throws Exception;	

}
