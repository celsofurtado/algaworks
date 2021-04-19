package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;

@Component
public class EstadoRepositoryImpl implements EstadoRepository {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Estado> all() {
		return manager.createQuery("FROM Estado", Estado.class).getResultList();
	}

	@Override
	public Estado findById(Long id) {
		return manager.find(Estado.class, id);
	}

	@Override
	@Transactional
	public Estado add(Estado estado) {
		return manager.merge(estado);
	}

	@Override
	@Transactional
	public void remove(Estado estado) {
		estado = manager.find(Estado.class, estado.getId());
		manager.remove(estado);
	}

}
