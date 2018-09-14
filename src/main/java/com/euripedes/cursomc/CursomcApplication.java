package com.euripedes.cursomc;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.euripedes.cursomc.domain.Categoria;
import com.euripedes.cursomc.domain.Produto;
import com.euripedes.cursomc.repositories.CategoriaRepository;
import com.euripedes.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	@Autowired //instancia automático
	private CategoriaRepository categoriaRepository; //dependencia
	@Autowired//instancia automático
	private ProdutoRepository produtoRepository;//criar dependência repository
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		
		Categoria cat1 = new Categoria (null, "informatica");
		Categoria cat2 = new Categoria (null, "Escritório");
		
		
		Produto p1 = new Produto (null, "computador", 2000.00);
		Produto p2 = new Produto (null, "impressora", 80.00);
		Produto p3 = new Produto (null, "mouse", 80.00);
		
		//adicionar estes tres produtos na lista de categoria correspondente/associado
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));		
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		
		
		categoriaRepository.save(Arrays.asList(cat1, cat2));//chamando o objeto 
		produtoRepository.save(Arrays.asList(p1,p2,p3));
		
		
	}
}
//executar a instanciação no memento que iniciar