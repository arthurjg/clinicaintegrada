package com.pixeon.clinicac.service;

import java.io.InputStream;

public interface ExameService {
	
	public InputStream buscaExame(Integer codigoPaciente, Integer codigoExame) throws Exception;

}
