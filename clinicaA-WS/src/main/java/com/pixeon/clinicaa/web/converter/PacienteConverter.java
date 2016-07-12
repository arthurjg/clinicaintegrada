package com.pixeon.clinicaa.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.pixeon.clinicaa.model.Paciente;

@FacesConverter(forClass = Paciente.class)
public class PacienteConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		Paciente clinica = null;
		if (value != null && value.trim().length() > 0) {
			Integer codigo = Integer.valueOf(value);
			clinica = new Paciente();
			clinica.setId(codigo);
		}
		return clinica;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Paciente clinica = (Paciente) value;
			return clinica.getId().toString();
		}
		return "";
	}

}
