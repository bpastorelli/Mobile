package br.com.mobile.stepDefinition;

import br.com.mobile.controllers.GlobalStepsController;
import br.com.mobile.reports.LogReport;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class GlobalSteps {
	
	private GlobalStepsController controller = new GlobalStepsController(); 

	@Given("^Que eu quero testar \"([^\"]*)\"$")
	public void que_eu_quero_testar(String arg1) throws Throwable {
		LogReport.createTest("Iniciando o Teste: " + arg1);
	}
	
	@And("^Clico no botao \"([^\"]*)\" da pagina (.*)$")
	public void clicoBotao(String botao, String pagina) {
		
		controller.getAction(pagina).clicarBotao(botao);
	}
	
	@And("^Deslizo para a esquerda e visualizo (.*) telas na pagina (.*)$")
	public void delizo_para_esquerda(Integer qtde, String pagina) throws Exception {
		
		controller.getAction(pagina).deslizarParaDireita(qtde);
	}
	
	@And("^Deslizo para a direita e visualizo (.*) telas na pagina (.*)$")
	public void delizo_para_direita(Integer qtde, String pagina) throws Exception {
		
		controller.getAction(pagina).deslizarParaDireita(qtde);
	}
	
	@When("^Encontro o texto (.*) na pagina (.*)$")
	public void abrir_aplicativo_na_tela(String texto, String pagina) {
		
		controller.getAction(pagina).validarTextoPagina(texto, "Texto esperado na pagina: " + texto);
	}
	
	@And("^Deslizo a tela para cima (.*) vezes na pagina (.*)$")
	public void deslizo_tela_para_cima(Integer qtde, String pagina) {
		
		controller.getAction(pagina).deslizarParaCima(qtde);
	}
	
	@And("^Deslizo a tela para baixo (.*) vezes na pagina (.*)$")
	public void deslizo_tela_para_baixo(Integer qtde, String pagina) {
		
		controller.getAction(pagina).deslizarParaBaixo(qtde);
	}

}
