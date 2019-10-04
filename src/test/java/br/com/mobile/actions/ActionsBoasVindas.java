package br.com.mobile.actions;

import br.com.mobile.interfaces.Actions;
import br.com.mobile.pages.BoasVindasPage;
import br.com.mobile.reports.LogReport;

public class ActionsBoasVindas implements Actions {
	
	private BoasVindasPage boasVindasPage = new BoasVindasPage();
	
	public void validarTextoPagina(String textoEsperado, String mensagem) {
		
		LogReport.passFail(boasVindasPage.textoExibidoPagina(textoEsperado), mensagem);
	}
	
	@Override
	public void clicarBotao(String botao) {
		
		boasVindasPage.touchDownDisplayed(botao);
		boasVindasPage.clicarBotao(botao);
	}
	
	@Override
	public void deslizarParaEsquerda(int qtde) throws Exception {
		
		boasVindasPage.deslizarParaEsquerda(qtde);
	}
	
	@Override
	public void deslizarParaDireita(int qtde) throws Exception {
		
		boasVindasPage.deslizarParaDireia(qtde);
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

	@Override
	public void deslizarParaCima(int qtde) {
		
		boasVindasPage.deslizarParaCima(qtde);
	}

	@Override
	public void deslizarParaBaixo(int qtde) {
		
		boasVindasPage.deslizarParaBaixo(qtde);
	}
}
