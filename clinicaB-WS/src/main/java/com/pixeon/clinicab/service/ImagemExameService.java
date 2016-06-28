package com.pixeon.clinicab.service;

import java.io.InputStream;

public interface ImagemExameService {
	
	public InputStream buscaImagemExame(Integer codigoPaciente, Integer codigoExame) throws Exception;

}
