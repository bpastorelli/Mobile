package br.com.mobile.stepDefinition;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.mobile.actions.ActionsConfiguration;
import cucumber.api.java.en.And;

public class ConfigurationSteps {
	
	@Autowired
	private ActionsConfiguration actionsConfiguration;
	
	@And("^Configuro a quantidade de noticias para \"([^\"]*)\"$")
	public void configuro_quantidade_de_noticias(String opcao) {
		
		actionsConfiguration.clicarOpcaoQuantidadeNoticias(opcao);
	}
	
	@And("^Configuro tipos de alertas \"([^\"]*)\"$")
	public void configuro_tipos_alertas(String tipo) {
		
		actionsConfiguration.clicarSetarTiposAlertas(tipo);
	}
}
