package com.pixeon.clinicaa.web.util;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import com.amazonaws.AmazonClientException;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;

public class FileSaver {
	
	@Inject
	private HttpServletRequest request;
	
	@Inject
	private AmazonS3Client s3Client;
	
	@Inject
	private MensagemUtil mensagemUtil;
	
	private static final String CONTENT_DISPOSITION = "content-disposition";

	private static final String FILENAME_KEY = "filename=";
	
	public String write(String baseFolder, Part multipartFile) {
		
		String serverPath = request.getServletContext().getRealPath("/" + baseFolder);
		String fileName = extractFilename(multipartFile.getHeader(CONTENT_DISPOSITION));
		String path = serverPath + "/" + fileName;
		try {
			multipartFile.write(path);
		} catch (IOException e){
			throw new RuntimeException(e);
		}
		return baseFolder + "/" + fileName;
	}
	
	public String writeOnExternal(String baseFolder, Part multipartFile) {			
		
		String fileName = extractFilename(multipartFile.getHeader(CONTENT_DISPOSITION));		
		try {
			s3Client.putObject("clinica-a/" + baseFolder, fileName,
					multipartFile.getInputStream(), new ObjectMetadata());
			return "http://localhost:9444/s3/clinica-a/" + baseFolder + "_" + fileName + "?noAuth=true";
		} catch (AmazonClientException | IOException e) {
			mensagemUtil.adicionaMensagem(
					"Houve algum erro ao salvar as imagens, por favor tente mais tarde.");
			return null;
		}		
	}

	private String extractFilename(String contentDisposition) {
		if (contentDisposition == null) {
			return null;
		}
		int startIndex = contentDisposition.indexOf(FILENAME_KEY);
		if (startIndex == -1) {
			return null;
		}
		String filename = contentDisposition.substring(startIndex + FILENAME_KEY.length());
		if (filename.startsWith("\"")) {
			int endIndex = filename.indexOf("\"", 1);
			if (endIndex != -1) {
				return filename.substring(1, endIndex);
			}
		} else {
			int endIndex = filename.indexOf(";");
			if (endIndex != -1) {
				return filename.substring(0, endIndex);
			}
		}
		return filename;
	}	

}
