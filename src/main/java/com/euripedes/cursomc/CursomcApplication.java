package com.euripedes.cursomc;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.euripedes.cursomc.domain.Categoria;
import com.euripedes.cursomc.domain.Cidade;
import com.euripedes.cursomc.domain.Estado;
import com.euripedes.cursomc.domain.Produto;
import com.euripedes.cursomc.repositories.CategoriaRepository;
import com.euripedes.cursomc.repositories.CidadeRepository;
import com.euripedes.cursomc.repositories.EstadoRepository;
import com.euripedes.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	@Autowired //instancia automático
	private CategoriaRepository categoriaRepository; //dependencia
	@Autowired//instancia automático
	private ProdutoRepository produtoRepository;//criar dependência repository
	@Autowired//instancia automático
	private CidadeRepository cidadeRepository;//criar dependência repository
	@Autowired
	private EstadoRepository estadoRepository;//criar dependência repository
	
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
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade (null, "uberlandia", est1);
		Cidade c2 = new Cidade (null, "sao paulo", est2);
		Cidade c3 = new Cidade (null, "campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		//salvar no banco criar a classe repository control c control v na classe
		
		categoriaRepository.save(Arrays.asList(cat1, cat2));//chamando o objeto 
		produtoRepository.save(Arrays.asList(p1,p2,p3));
		estadoRepository.save(Arrays.asList(est1,est2));
		cidadeRepository.save(Arrays.asList(c1,c2,c3));
		
		
	}
}
//executar a instanciação no memento que iniciar