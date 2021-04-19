package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;

@Component
public class CozinhaRepositoryImpl implements CozinhaRepository {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Cozinha> all() {
		return manager.createQuery("from Cozinha", Cozinha.class).getResultList();
	}
	
	@Override
	@Transactional
	public Cozinha add(Cozinha cozinha) {
		return manager.merge(cozinha);
	}
	
	@Override
	public Cozinha findById(Long id) {
		return manager.find(Cozinha.class, id);
	}
	
	@Override
	@Transactional
	public void remove(Cozinha cozinha) {
		cozinha = findById(cozinha.getId());
		manager.remove(cozinha);
	}

}
