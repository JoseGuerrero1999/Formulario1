package com.practica1.service;

import java.util.List;

import com.practica1.entity.Formulario;

public interface FormularioService {

	public abstract List<Formulario>listaforumario();
	public abstract Formulario insertaActualizaFormulario (Formulario obj);
}
