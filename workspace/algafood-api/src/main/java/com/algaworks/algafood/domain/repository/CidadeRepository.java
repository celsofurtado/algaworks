package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.Cidade;

public interface CidadeRepository {

	List<Cidade> all();

	Cidade findById(Long id);

	Cidade add(Cidade cidade);

	void remove(Cidade cidade);

}
