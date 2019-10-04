package br.com.mobile.actions;

import br.com.mobile.pages.BoasVindasPage;
import br.com.mobile.pages.ConfigurationPage;
import br.com.mobile.reports.LogReport;

public class ActionsMobile {
	
	private BoasVindasPage boasVindasPage = new BoasVindasPage();
	
	private ConfigurationPage configurationPage = new ConfigurationPage();
	
	public void validarTextoPagina(String textoEsperado, String mensagem) {
		
		LogReport.passFail(boasVindasPage.textoExibidoPagina(textoEsperado), mensagem);
	}
	
	public void clicarBotao(String botao) {
		
		boasVindasPage.touchDownDisplayed(botao);
		boasVindasPage.clicarBotao(botao);
	}
	
	public void deslizarParaEsquerda(int qtde) throws Exception {
		
		boasVindasPage.deslizarParaEsquerda(qtde);
	}
	
	public void deslizarParaDireita(int qtde) throws Exception {
		
		boasVindasPage.deslizarParaDireita(qtde);
	}
	
	public void deslizarParaCima(int qtde) {
		
		configurationPage.deslizarParaCima(qtde);
	}
	
	public void deslizarParaBaixo(int qtde) {
		
		configurationPage.deslizarParaBaixo(qtde);
	}
	
	public void instalarApp() {
		
		boasVindasPage.setupEnviroment();
	}
	
	public void finalizarApp() throws Exception {
		
		boasVindasPage.driverClose();
	}
	
	public void desinstalarApp() {
		
		boasVindasPage.uninstallApp();
	}
	
	public void clicarOpcaoQuantidadeNoticias(String opcao) {
		
		configurationPage.clicarBotao(opcao);
	}
	
	public void clicarSetarTiposAlertas(String tipo) {
		
		configurationPage.clicarBotao(tipo);
	}
}
