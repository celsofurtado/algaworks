package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.model.Permissao;
import com.algaworks.algafood.domain.repository.PermissaoRepository;

@Component
public class PermissaoRepositoryImpl implements PermissaoRepository {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Permissao> all() {
		return manager.createQuery("FROM Permissao", Permissao.class).getResultList();
	}

	@Override
	public Permissao findById(Long id) {
		return manager.find(Permissao.class, id);
	}

	@Override
	@Transactional
	public Permissao add(Permissao permissao) {
		return manager.merge(permissao);
	}

	@Override
	@Transactional
	public void remove(Permissao permissao) {
		permissao = manager.find(Permissao.class, permissao.getId());
		manager.remove(permissao);
	}

}
