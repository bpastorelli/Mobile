package br.com.mobile.stepDefinition;

import br.com.mobile.actions.ActionsInicial;
import cucumber.api.java.en.And;

public class InicialSteps {
	
	private ActionsInicial actionsInicial = new ActionsInicial();
	
	@And("^Caso apareça um popup com a mensagem \"([^\"]*)\" clico na opcao \"([^\"]*)\"$")
	public void configuro_quantidade_de_noticias(String mensagem, String opcao) {
		
		actionsInicial.naoInstalarNovaVersao(mensagem, opcao);
	}
	
	@And("^Que eu ja esteja autenticado$")
	public void que_eu_ja_esteja_autenticado() {
		
		
		
	}
	
}
