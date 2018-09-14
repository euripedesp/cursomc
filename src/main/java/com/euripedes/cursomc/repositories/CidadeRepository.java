package com.euripedes.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.euripedes.cursomc.domain.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository <Cidade, Integer>{ //várias operações de acesso a dados 

}
