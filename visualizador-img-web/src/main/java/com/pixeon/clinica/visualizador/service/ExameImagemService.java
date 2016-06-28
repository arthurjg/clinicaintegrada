package com.pixeon.clinica.visualizador.service;

import java.io.InputStream;

public interface ExameImagemService {
	
	public InputStream buscaExameImagem(String dominio, String porta, String contexto, String recurso, 
			String pacienteParametro, String exameParametro, Integer codigoPaciente, Integer codigoExame);

}
