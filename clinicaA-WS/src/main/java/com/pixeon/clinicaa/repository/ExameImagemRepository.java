package com.pixeon.clinicaa.repository;

import java.io.InputStream;

public interface ExameImagemRepository {
	
	public InputStream buscaExameImagem(Integer codigoPaciente, Integer codigoExame) throws Exception;	

}
