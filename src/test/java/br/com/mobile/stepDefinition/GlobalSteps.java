package br.com.mobile.stepDefinition;

import br.com.mobile.reports.LogReport;
import cucumber.api.java.en.Given;

public class GlobalSteps {

	@Given("^Que eu quero testar \"([^\"]*)\"$")
	public void que_eu_quero_testar(String arg1) throws Throwable {
		LogReport.createTest("Iniciando o Teste: " + arg1);
	}
}
