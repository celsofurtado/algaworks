package com.algaworks.algafood.jpa;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

public class ConsultaCozinhaMain {

	public static void main(String[] args) {
		
		// *** Executar a aplicação ignorando o servidor WEB. É para executar como aplicação local.
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		// *** Obter instancia do objeto CadastroCozinha
		CozinhaRepository cozinhaRepository = applicationContext.getBean(CozinhaRepository.class);
		
		// *** Cadastrar cozinhas
		Cozinha cozinha1 = new Cozinha();
		cozinha1.setNome("Brasileira");
		
		Cozinha cozinha2 = new Cozinha();
		cozinha2.setNome("Chinesa");
		
		Cozinha cozinha33 = new Cozinha();
		cozinha33.setNome("Argentina");
		
		cozinha1 = cozinhaRepository.add(cozinha1);
		cozinha2 = cozinhaRepository.add(cozinha2);
		cozinha33 = cozinhaRepository.add(cozinha33);
		
		System.out.printf("%d - %s\n", cozinha1.getId(), cozinha1.getNome());
		System.out.printf("%d - %s\n", cozinha2.getId(), cozinha2.getNome());
		
		// *** Listar Cozinhas cadastradas
		List<Cozinha> cozinhas = cozinhaRepository.all();
		
		for (Cozinha cozinha : cozinhas) {
			System.out.println(cozinha.getNome());
		}
		
		// *** Buscar cozinha por id
		cozinha2 = cozinhaRepository.findById(3l);
		System.out.printf("\n\n%d, %s\n\n", cozinha2.getId(), cozinha2.getNome());
		
		
		// *** Atualizar cozinha
		Cozinha cozinha3 = new Cozinha();
		cozinha3.setId(1l);
		cozinha3.setNome("XPTO");
		cozinhaRepository.add(cozinha3);
		
		// *** Excluir cozinha
		Cozinha c4 = new Cozinha();
		c4.setId(2L);
		cozinhaRepository.remove(c4);
		
		// *** Adicionar Restaurante
		Restaurante r1 = new Restaurante();
		r1.setNome("Mais que Donalds");
		r1.setTaxaFrete(BigDecimal.valueOf(6.99));
		
		RestauranteRepository rRep = applicationContext.getBean(RestauranteRepository.class);
		
		rRep.add(r1);
		
		
	}

}
