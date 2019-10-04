package br.com.mobile.stepDefinition;

import br.com.mobile.actions.ActionsBoasVindas;
import br.com.mobile.actions.ActionsConfiguration;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

public class ConfigurationSteps {
	
	private ActionsBoasVindas actionsBoasVindas = new ActionsBoasVindas();
	
	private ActionsConfiguration actionsConfiguration = new ActionsConfiguration();
	
	@When("^Encontro o texto (.*) na tela atual$")
	public void abrir_aplicativo_na_tela(String texto) {
		
		actionsBoasVindas.validarTextoPagina(texto, "Texto esperado na pagina: " + texto);		
	}
	
	@And("^Clico no botao \"([^\"]*)\"$")
	public void clicoBotao(String botao) {
		
		actionsBoasVindas.clicarBotao(botao);
	}
	
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
	
	@And("^Configuro a quantidade de noticias para \"([^\"]*)\"$")
	public void configuro_quantidade_de_noticias(String opcao) {
		
		actionsConfiguration.clicarOpcaoQuantidadeNoticias(opcao);
	}
	
	@And("^Configuro tipos de alertas \"([^\"]*)\"$")
	public void configuro_tipos_alertas(String tipo) {
		
		actionsConfiguration.clicarSetarTiposAlertas(tipo);
	}
	
	@And("^Deslizo a tela para cima (.*) vezes$")
	public void deslizo_tela_para_cima(Integer qtde) {
		
		actionsConfiguration.deslizarParaCima(qtde);
	}
	
	@And("^Deslizo a tela para baixo (.*) vezes$")
	public void deslizo_tela_para_baixo(Integer qtde) {
		
		actionsConfiguration.deslizarParaBaixo(qtde);
	}

}
