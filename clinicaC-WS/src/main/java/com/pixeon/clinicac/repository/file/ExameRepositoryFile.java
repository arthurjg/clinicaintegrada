package com.pixeon.clinicac.repository.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import com.pixeon.clinicac.repository.ExameRepository;

public class ExameRepositoryFile implements ExameRepository {
	
	@Inject
	private HttpServletRequest request;

	@Override
	public InputStream buscaExame(Integer codigoPaciente, Integer codigoExame) throws Exception {
		InputStream exameInputSteam = null;
		try {
			String caminhoExames = request.getServletContext().getRealPath("exames");
			String caminhoPaciente = caminhoExames + File.separator + codigoPaciente.toString();
			String caminhoExame = caminhoPaciente + File.separator + codigoExame.toString() + ".jpg";
			File exame = new File(caminhoExame);
			exameInputSteam = new FileInputStream(exame);
		} catch(FileNotFoundException exception){
			throw new Exception("Não foi encontrada imagem com esse código de exame e paciente");
		}		
		return exameInputSteam;
	}

}
