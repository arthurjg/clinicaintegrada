package com.pixeon.clinicac.repository;

import java.io.InputStream;

public interface ExameRepository {
	
	public InputStream buscaExame(Integer codigoPaciente, Integer codigoExame) throws Exception;

}
