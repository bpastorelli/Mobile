package br.com.mobile.stepDefinition;

import br.com.mobile.actions.ActionsMobile;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

public class MobileSteps {
	
	private ActionsMobile actionsMobile = new ActionsMobile();
	
	@When("^Encontro o texto (.*) na tela atual$")
	public void abrir_aplicativo_na_tela(String texto) {
		
		actionsMobile.validarTextoPagina(texto);		
	}
	
	@And("^Clico no botao (.*)$")
	public void clicoBotao(String botao) {
		
		actionsMobile.clicarBotao(botao);
	}
	
	@And("^Deslizo para a esquerda e visualizo (.*) telas$")
	public void delizo_para_direita(Integer qtde) throws Exception {
		
		actionsMobile.deslizarParaEsquerda(qtde);
	}

}
