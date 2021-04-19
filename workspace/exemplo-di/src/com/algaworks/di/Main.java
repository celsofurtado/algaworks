package com.algaworks.di;

import com.algaworks.di.modelo.Cliente;
import com.algaworks.di.notificacao.Notificador;
import com.algaworks.di.notificacao.NotificadorEmail;
import com.algaworks.di.notificacao.NotificadorSms;
import com.algaworks.di.service.AtivacaoClienteService;

public class Main {

	public static void main(String[] args) {
		
		Cliente joao = new Cliente("Joao", "joao@email.com", "45124545");
		Cliente maria = new Cliente("Maria", "maria@uol.com.br", "89564655");
		
		Notificador notificadorEmail = new NotificadorEmail();
		Notificador notificadorSMS = new NotificadorSms();
		
		AtivacaoClienteService ativacaoClienteService = new AtivacaoClienteService(notificadorSMS);
		ativacaoClienteService.ativar(joao);
		ativacaoClienteService.ativar(maria);

	}

}
