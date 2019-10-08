package br.com.mobile.stepDefinition;

import br.com.mobile.controllers.GlobalStepsController;
import br.com.mobile.reports.LogReport;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class GlobalSteps {
	
	private GlobalStepsController controller = new GlobalStepsController(); 
	
	@When("^Encontro o texto (.*) na pagina (.*)$")
	public void abrir_aplicativo_na_tela(String texto, String pagina) {
		
		controller.getAction(pagina).validarTextoPagina(texto, "Texto esperado na pagina: " + texto);
	}

	@Given("^Que eu quero testar \"([^\"]*)\"$")
	public void que_eu_quero_testar(String arg1) throws Throwable {
		
		LogReport.createTest("Iniciando o Teste: " + arg1);
	}
	
	@And("^Clico no botao \"([^\"]*)\" da pagina (.*)$")
	public void clicoBotao(String botao, String pagina) {
		
		controller.getAction(pagina).clicarBotao(botao);
	}
	
	@And("^Deslizo para a esquerda e visualizo (.*) telas$")
	public void delizo_para_esquerda(Integer qtde) throws Exception {
		
		controller.getAction().deslizarParaEsquerda(qtde);
	}
	
	@And("^Deslizo para a direita e visualizo (.*) telas$")
	public void delizo_para_direita(Integer qtde) throws Exception {
		
		controller.getAction().deslizarParaDireita(qtde);
	}
	
	@And("^Deslizo a tela para cima (.*) vezes$")
	public void deslizo_tela_para_cima(Integer qtde) {
		
		controller.getAction().deslizarParaCima(qtde);
	}
	
	@And("^Deslizo a tela para baixo (.*) vezes$")
	public void deslizo_tela_para_baixo(Integer qtde) {
		
		controller.getAction().deslizarParaBaixo(qtde);
	}
	
	@And("^Desinstalo o aplicativo do dispositivo$")
	public void desinstalo_aplicativo_dispositivo() {
		
		controller.getAction().desinstalarApp();
	}
	
	@And("^Reinstalo o aplicativo no dispositivo$")
	public void reinstalo_aplicativo_dispositivo() {
		
		controller.getAction().instalarApp();
	}
	
	@And("^Finalizo o aplicativo inicializado$")
	public void finalizo_aplicativo_inicializado() throws Exception {
		
		controller.getAction().finalizarApp();
	}
	
	@And("^Deslizo para a direita e clico no botao \"([^\"]*)\"$")
	public void deslizo_para_direita_clico_no_botao(String botao) {
		
		controller.getAction().deslizarParaDireitaTextoVisivel(botao);
		controller.getAction().clicarBotao(botao);
	}
	
	@And("^Deslizo para a esquerda e clico no botao \"([^\"]*)\"$")
	public void deslizo_para_esquerda_clico_no_botao(String botao) {
		
		controller.getAction().deslizarParaEsquerdaTextoVisivel(botao);
		controller.getAction().clicarBotao(botao);
	}
	
	@And("^Deslizo para a esquerda até o texto \"([^\"]*)\"$")
	public void deslizo_esquerda_ate_o_texto(String texto) {
		
		controller.getAction().deslizarParaEsquerdaTextoVisivel(texto);
	}
	
	@And("^Deslizo para a direita até o texto \"([^\"]*)\"$")
	public void deslizo_direita_ate_o_texto(String texto) {
		
		controller.getAction().deslizarParaDireitaTextoVisivel(texto);
	}
			
}
