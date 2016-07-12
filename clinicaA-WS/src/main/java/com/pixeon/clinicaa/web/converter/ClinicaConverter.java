package com.pixeon.clinicaa.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.pixeon.clinicaa.model.Clinica;

@FacesConverter(forClass = Clinica.class)
public class ClinicaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		Clinica clinica = null;
		if (value != null && value.trim().length() > 0) {
			Integer codigo = Integer.valueOf(value);
			clinica = new Clinica();
			clinica.setId(codigo);
		}
		return clinica;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Clinica clinica = (Clinica) value;
			return clinica.getId().toString();
		}
		return "";
	}

}
