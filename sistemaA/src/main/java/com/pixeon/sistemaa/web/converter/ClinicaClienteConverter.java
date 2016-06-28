package com.pixeon.sistemaa.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.pixeon.sistemaa.model.ClinicaCliente;

@FacesConverter(forClass = ClinicaCliente.class)
public class ClinicaClienteConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		ClinicaCliente clinicaCliente = null;
		if (value != null && value.trim().length() > 0) {
			Integer codigo = Integer.valueOf(value);
			clinicaCliente = new ClinicaCliente();
			clinicaCliente.setId(codigo);
		}
		return clinicaCliente;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			ClinicaCliente clinicaCliente = (ClinicaCliente) value;
			return clinicaCliente.getId().toString();
		}
		return "";
	}

}
