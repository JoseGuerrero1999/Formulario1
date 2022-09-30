package com.practica1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica1.entity.Formulario;
import com.practica1.repository.FormularioRepository;

@Service
public class FormularioServiceImp implements FormularioService{

	@Autowired
	private FormularioRepository formrepo;
	
	@Override
	public List<Formulario> listaforumario() {
		return formrepo.findAll();
	}

	@Override
	public Formulario insertaActualizaFormulario(Formulario obj) {
	
		return formrepo.save(obj);
	}

	
}
