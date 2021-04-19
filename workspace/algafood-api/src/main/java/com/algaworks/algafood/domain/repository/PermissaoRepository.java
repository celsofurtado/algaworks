package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.Permissao;

public interface PermissaoRepository {

	List<Permissao> all();

	Permissao findById(Long id);

	Permissao add(Permissao permissao);

	void remove(Permissao permissao);

}
