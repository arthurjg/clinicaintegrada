package com.pixeon.clinica.visualizador.web;

import java.io.InputStream;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.application.ResourceHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.pixeon.clinica.visualizador.service.ExameImagemService;

@ManagedBean
@ApplicationScoped
public class ImagemResourceBean {
	
	@Inject
	private HttpServletRequest request;
	
	@Inject
	private ExameImagemService exameImagemService;
	
	private StreamedContent imagem;
	
	public StreamedContent getImagem() {				
		
		FacesContext context = FacesContext.getCurrentInstance();
        ResourceHandler handler = context.getApplication().getResourceHandler();
        if(handler.isResourceRequest(context)){             	
        	InputStream imagemExameInputStream = constroiImagem();  
        	if(imagemExameInputStream == null){
        		imagem = new DefaultStreamedContent();    
        	} else {
        		imagem = new DefaultStreamedContent(imagemExameInputStream, "image/jpeg");
        	}    		
    	} else {
        	imagem = new DefaultStreamedContent();    		
        }
		
		return imagem;
	}
	
	private InputStream constroiImagem(){
		
		String dominioRest = request.getParameter("dominioRest");
		String contextoRest = request.getParameter("contextoRest");
		String portaRest = request.getParameter("portaRest");
		String recursoRest = request.getParameter("recursoRest");
		String pacienteParametro = request.getParameter("pacienteParametro");
		String exameParametro = request.getParameter("exameParametro");

		String pacienteCodigoValor = request.getParameter("pacienteCodigo");
		String exameCodigoValor = request.getParameter("exameCodigo");
		
		Integer pacienteCodigo = null;
		Integer exameCodigo = null;

		if (pacienteCodigoValor != null && exameCodigoValor != null) {
			pacienteCodigo = Integer.parseInt(pacienteCodigoValor);
			exameCodigo = Integer.parseInt(exameCodigoValor);
		}
		
		if(dominioRest != null && portaRest != null && contextoRest != null && recursoRest != null
				&& pacienteParametro != null && exameParametro != null 
				&& pacienteCodigo != null && exameCodigo != null){
			return
					exameImagemService.buscaExameImagem(dominioRest, portaRest, contextoRest, recursoRest, 
					pacienteParametro, exameParametro, pacienteCodigo, exameCodigo);			
			
		} else {
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage message = new FacesMessage("Parametros invalidos ou insuficientes");
			context.addMessage(null, message);
			return null;
		}		
    	
	}	

}
