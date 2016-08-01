package com.pixeon.sistemaa.web.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

public class MensagemUtil {
	
	@Inject
	private FacesContext faceContext;
	
	public void adicionaMensagem(String menssagem){		
		FacesMessage facesMessage = new FacesMessage(menssagem);
		faceContext.addMessage( null, facesMessage);
	}

	public FacesContext getFaceContext() {
		return faceContext;
	}

	public void setFaceContext(FacesContext faceContext) {
		this.faceContext = faceContext;
	}

}
