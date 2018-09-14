package com.euripedes.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.euripedes.cursomc.domain.Categoria;
import com.euripedes.cursomc.repositories.CategoriaRepository;
import com.euripedes.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	public Categoria buscar(Integer id) {
		Categoria obj = repo.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("objeto não encontrado id: " + id 
					+ ", tipo: "+ Categoria.class.getName());
		}
		return obj;
		
	}

}
