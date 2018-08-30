package com.euripedes.cursomc.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (value="/categorias")//end point rest
public class CategoriaResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public String listar() {
		return "rest está funcionando";
	}

}
