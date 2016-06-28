package com.pixeon.sistemaa.web.util;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class URLConfigUtil {
	
	public static String montaContextoURL(String dominio, String porta, String contexto, String secao){
		return "http://" + dominio + ":" + porta + "/" + contexto + "/" + secao;
	}
	
	public static String montaParametrosURL(Map<String, Object> parametros){		
		String parametrosURL = "?";
		Set<String> parametrosNomes = parametros.keySet();
		Iterator<String> parametrosNomesIterator = parametrosNomes.iterator();
		
		while(parametrosNomesIterator.hasNext()){
			String parametroNome = parametrosNomesIterator.next();
			parametrosURL += parametroNome;
			parametrosURL += "=";
			parametrosURL += parametros.get(parametroNome);
			if(parametrosNomesIterator.hasNext()){
				parametrosURL += "&";	
			}					
		}
		return parametrosURL;		
	}	

}
