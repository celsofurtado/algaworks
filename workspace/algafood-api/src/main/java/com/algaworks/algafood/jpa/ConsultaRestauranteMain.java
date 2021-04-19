package com.algaworks.algafood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

public class ConsultaRestauranteMain {

	public static void main(String[] args) {
		
		// *** Executar a aplicação ignorando o servidor WEB. É para executar como aplicação local.
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		// *** Obter instancia do objeto CadastroCozinha
		RestauranteRepository restauranteRepository = applicationContext.getBean(RestauranteRepository.class);
		
		// *** Listar Cozinhas cadastradas
		List<Restaurante> restaurantes = restauranteRepository.all();
		
		for (Restaurante restaurante : restaurantes) {
			System.out.printf("%s - \t%f - \t%s\n", 
					restaurante.getNome(),
					restaurante.getTaxaFrete(),
					restaurante.getCozinha().getNome());
		}
		
	}

}
