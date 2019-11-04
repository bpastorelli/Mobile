package br.com.mobile.stepDefinition;

import br.com.mobile.actions.android.ActionsMobile;
import br.com.mobile.reports.LogReport;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class GlobalSteps {
	
	private ActionsMobile actionsMobile = new ActionsMobile();

	@Given("^Que eu quero testar \"([^\"]*)\"$")
	public void que_eu_quero_testar(String arg1) throws Throwable {
		
		LogReport.createTest(arg1);
	}
	
	@Then("^Valido o teste com o texto \"([^\"]*)\" na pagina atual$")
	public void valido_teste_com_texto_na_pagina_atual(String texto) {
		
		actionsMobile.validarTexto(texto);
	}
	
}
