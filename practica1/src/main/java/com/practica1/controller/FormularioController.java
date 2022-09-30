package com.practica1.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.practica1.entity.Formulario;
import com.practica1.service.FormularioService;

@RestController
@RequestMapping("/formulario")
public class FormularioController  {

	@Autowired
	private FormularioService formserv;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Formulario>> listaformulario(){
		List<Formulario> lista = formserv.listaforumario();
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<?> inserta(@Valid @RequestBody Formulario obj , Errors errors){
		HashMap<String, Object> salida = new HashMap<>();
		List<String> lstMensaje= new ArrayList<String>();
		salida.put("Resultado", lstMensaje);
		List<ObjectError> lstErrors = errors.getAllErrors();
		for (ObjectError objectError : lstErrors) {
			objectError.getDefaultMessage();
			lstMensaje.add(objectError.getDefaultMessage());
		}
		if (!CollectionUtils.isEmpty(lstMensaje)) {
			return ResponseEntity.ok(salida);	
		}
		obj.setFechaActual(new Date());
		Formulario objSalida = formserv.insertaActualizaFormulario(obj);
		if (objSalida == null) {
			lstMensaje.add("Error al registrar");
		}else {
			lstMensaje.add("Se registro la persona " + objSalida.getCodigoFor());
		}
		return ResponseEntity.ok(salida);
		
	}
	
}
