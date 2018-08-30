package com.euripedes.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.euripedes.cursomc.domain.Categoria;
import com.euripedes.cursomc.services.CategoriaService;

@RestController
@RequestMapping (value="/categorias")//end point rest
public class CategoriaResource {
	
	@Autowired //instancia automaticamente
	private CategoriaService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) { //resposta http para rest
		Categoria obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
		
		/*Categoria cat1 = new Categoria (1, "Informática");
		Categoria cat2 = new Categoria (2, "escritório");
		
		List<Categoria> lista = new ArrayList<>();
		lista.add(cat1);
		lista.add(cat2);
		
		return lista;*/
	}

}
