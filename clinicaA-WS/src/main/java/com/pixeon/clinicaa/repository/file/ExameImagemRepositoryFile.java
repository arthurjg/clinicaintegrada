package com.pixeon.clinicaa.repository.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import com.pixeon.clinicaa.repository.ExameImagemRepository;

public class ExameImagemRepositoryFile implements ExameImagemRepository {
	
	@Inject
	private HttpServletRequest request;;

	@Override
	public InputStream buscaExameImagem(Integer codigoPaciente, Integer codigoExame) throws Exception {
		InputStream imagemExameInputSteam = null;
		try {
			String caminhoExames = request.getServletContext().getRealPath("exames");
			String caminhoPaciente = caminhoExames + File.separator + codigoPaciente.toString();
			String caminhoExame = caminhoPaciente + File.separator + codigoExame.toString() + ".jpg";
			File exame = new File(caminhoExame);
			imagemExameInputSteam = new FileInputStream(exame);
		} catch(FileNotFoundException exception){
			throw new Exception("Não foi encontrada imagem com esse código de exame e paciente");
		}		
		return imagemExameInputSteam;
	}	

}
