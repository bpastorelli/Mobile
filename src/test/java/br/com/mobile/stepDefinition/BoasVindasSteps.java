package br.com.mobile.stepDefinition;

import br.com.mobile.actions.ActionsBoasVindas;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

public class BoasVindasSteps {
	
	private ActionsBoasVindas actionsBoasVindas = new ActionsBoasVindas();

	
	@And("^Desinstalo o aplicativo do dispositivo$")
	public void desinstalo_aplicativo_dispositivo() {
		
		actionsBoasVindas.desinstalarApp();
	}
	
	@And("^Reinstalo o aplicativo no dispositivo$")
	public void reinstalo_aplicativo_dispositivo() {
		
		actionsBoasVindas.instalarApp();
	}
	
	@And("^Finalizo o aplicativo inicializado$")
	public void finalizo_aplicativo_inicializado() throws Exception {
		
		actionsBoasVindas.finalizarApp();
	}

}
