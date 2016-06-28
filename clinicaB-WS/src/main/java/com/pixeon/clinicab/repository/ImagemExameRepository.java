package com.pixeon.clinicab.repository;

import java.io.InputStream;

public interface ImagemExameRepository {
	
	public InputStream buscaImagemExame(Integer codigoPaciente, Integer codigoExame) throws Exception;

}
