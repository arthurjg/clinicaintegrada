package com.pixeon.clinicac.service.rn;

import java.io.InputStream;

import javax.inject.Inject;

import com.pixeon.clinicac.repository.ExameRepository;
import com.pixeon.clinicac.service.ExameService;

public class ExameServiceRN implements ExameService {
	
	@Inject
	private ExameRepository exameRepository;

	@Override
	public InputStream buscaExame(Integer codigoPaciente, Integer codigoExame) throws Exception {		
		return exameRepository.buscaExame(codigoPaciente, codigoExame);
	}

}
