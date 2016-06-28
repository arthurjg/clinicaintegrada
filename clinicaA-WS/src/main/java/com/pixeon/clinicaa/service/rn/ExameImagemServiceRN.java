package com.pixeon.clinicaa.service.rn;

import java.io.InputStream;

import javax.inject.Inject;

import com.pixeon.clinicaa.repository.ExameImagemRepository;
import com.pixeon.clinicaa.service.ExameImagemService;

public class ExameImagemServiceRN implements ExameImagemService {
	
	@Inject
	private ExameImagemRepository exameImagemRepository;

	@Override
	public InputStream buscaExameImagem(Integer codigoPaciente, Integer codigoExame) throws Exception {		
		return exameImagemRepository.buscaExameImagem(codigoPaciente, codigoExame);
	}	

}
