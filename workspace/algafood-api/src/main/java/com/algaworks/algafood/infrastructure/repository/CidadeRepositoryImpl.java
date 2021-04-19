package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.repository.CidadeRepository;

@Component
public class CidadeRepositoryImpl implements CidadeRepository {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Cidade> all() {
		return manager.createQuery("FROM Cidade", Cidade.class).getResultList();
	}

	@Override
	public Cidade findById(Long id) {
		return manager.find(Cidade.class, id);
	}

	@Override
	@Transactional
	public Cidade add(Cidade cidade) {
		return manager.merge(cidade);
	}

	@Override
	@Transactional
	public void remove(Cidade cidade) {
		cidade = manager.find(Cidade.class, cidade.getId());
		manager.merge(cidade);
	}

	
	
}
