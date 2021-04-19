package com.algaworks.di.service;

import com.algaworks.di.modelo.Cliente;
import com.algaworks.di.modelo.Produto;
import com.algaworks.di.notificacao.Notificador;
import com.algaworks.di.notificacao.NotificadorEmail;
import com.algaworks.di.notificacao.NotificadorSms;

public class EmissaoNotaFiscalService {
	
	private Notificador notificador;
	
	public EmissaoNotaFiscalService(Notificador notificador) {
		this.notificador = notificador;
	}
	
	public void emitirNF(Cliente cliente, Produto produto) {
		// TODO emite nota fiscal aqui...
		
		this.notificador.notificar(cliente, 
				"Nota Fiscal do produto "
				+ produto.getNome() 
				+ " foi emitida.");
	}

}
