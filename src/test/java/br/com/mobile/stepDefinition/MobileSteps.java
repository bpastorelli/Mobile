package br.com.mobile.stepDefinition;

import br.com.mobile.actions.ActionsMobile;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

public class MobileSteps {
	
	private ActionsMobile actionsMobile = new ActionsMobile();
	
	@When("^Encontro o texto (.*) na tela atual$")
	public void abrir_aplicativo_na_tela(String texto) {
		
		actionsMobile.validarTextoPagina(texto, "Texto esperado na pagina: " + texto);		
	}
	
	@And("^Clico no botao \"([^\"]*)\"$")
	public void clicoBotao(String botao) {
		
		actionsMobile.clicarBotao(botao);
	}
	
	@And("^Deslizo para a esquerda e visualizo (.*) telas$")
	public void delizo_para_esquerda(Integer qtde) throws Exception {
		
		actionsMobile.deslizarParaEsquerda(qtde);
	}
	
	@And("^Deslizo para a direita e visualizo (.*) telas$")
	public void delizo_para_direita(Integer qtde) throws Exception {
		
		actionsMobile.deslizarParaDireita(qtde);
	}
	
	@And("^Desinstalo o aplicativo do dispositivo$")
	public void desinstalo_aplicativo_dispositivo() {
		
		actionsMobile.desinstalarApp();
	}
	
	@And("^Reinstalo o aplicativo no dispositivo$")
	public void reinstalo_aplicativo_dispositivo() {
		
		actionsMobile.instalarApp();
	}
	
	@And("^Finalizo o aplicativo inicializado$")
	public void finalizo_aplicativo_inicializado() throws Exception {
		
		actionsMobile.finalizarApp();
	}
	
	@And("^Configuro a quantidade de noticias para \"([^\"]*)\"$")
	public void configuro_quantidade_de_noticias(String opcao) {
		
		actionsMobile.clicarOpcaoQuantidadeNoticias(opcao);
	}
	
	@And("Configuro tipos de alertas \"([^\"]*)\"$")
	public void configuro_tipos_alertas(String tipo) {
		
		actionsMobile.clicarSetarTiposAlertas(tipo);
	}

}
