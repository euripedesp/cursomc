package com.euripedes.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.euripedes.cursomc.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository <Produto, Integer>{ //várias operações de acesso a dados 

}
