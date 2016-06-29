package com.pixeon.clinicaa.web;

import javax.inject.Inject;
import javax.servlet.http.Part;

import com.pixeon.clinicaa.model.Exame;
import com.pixeon.clinicaa.service.ExameImagemService;
import com.pixeon.clinicaa.web.util.FileSaver;
import com.pixeon.clinicaa.web.util.MensagemUtil;

public class ExameImagemBean {
	
	@Inject
	private ExameImagemService exameImagemService;
	
	@Inject
	private FileSaver fileSaver;
	
	@Inject
	private MensagemUtil mensagemUtil;
	
	private Exame exame = new Exame();
	private Part imagem;	
	
	public ExameImagemBean(){
		
	}
	
	public String salvar(){
		String imagemCaminho = fileSaver.writeOnExternal("sumarios", imagem);
		exame.setImagemCaminho(imagemCaminho);
		exameImagemService.salvar(exame);
		mensagemUtil.adicionaMensagem("exame salvo com sucesso.");
		limparDados();
		return "";
	}
	
	private void limparDados(){
		this.exame = new Exame();
	}

	public Exame getExame() {
		return exame;
	}

	public void setExame(Exame exame) {
		this.exame = exame;
	}

	public Part getImagem() {
		return imagem;
	}

	public void setImagem(Part imagem) {
		this.imagem = imagem;
	}

}
