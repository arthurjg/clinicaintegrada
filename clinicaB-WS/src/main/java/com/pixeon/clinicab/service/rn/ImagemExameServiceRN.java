package com.pixeon.clinicab.service.rn;

import java.io.InputStream;

import javax.inject.Inject;

import com.pixeon.clinicab.repository.ImagemExameRepository;
import com.pixeon.clinicab.service.ImagemExameService;

public class ImagemExameServiceRN implements ImagemExameService {
	
	@Inject
	private ImagemExameRepository imagemExameRepository;

	@Override
	public InputStream buscaImagemExame(Integer codigoPaciente, Integer codigoExame) throws Exception {		
		return imagemExameRepository.buscaImagemExame(codigoPaciente, codigoExame);
	}

}
