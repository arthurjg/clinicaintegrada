package com.pixeon.sistemaa.web.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MensagemUtil {
	
	public static void adicionaMensagem(String menssagem){
		FacesContext faceContext = FacesContext.getCurrentInstance();
		FacesMessage facesMessage = new FacesMessage(menssagem);
		faceContext.addMessage( null, facesMessage);
	}

}
