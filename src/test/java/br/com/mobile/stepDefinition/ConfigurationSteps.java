package br.com.mobile.stepDefinition;

import br.com.mobile.actions.ActionsConfiguration;
import cucumber.api.java.en.And;

public class ConfigurationSteps {
	
	private ActionsConfiguration actionsConfiguration = new ActionsConfiguration();
	
	@And("^Configuro a quantidade de noticias para \"([^\"]*)\"$")
	public void configuro_quantidade_de_noticias(String opcao) {
		
		actionsConfiguration.clicarOpcaoQuantidadeNoticias(opcao);
	}
	
	@And("^Configuro tipos de alertas \"([^\"]*)\"$")
	public void configuro_tipos_alertas(String tipo) {
		
		actionsConfiguration.clicarSetarTiposAlertas(tipo);
	}
}
