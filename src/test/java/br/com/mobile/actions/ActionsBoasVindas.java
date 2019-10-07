package br.com.mobile.actions;

import br.com.mobile.interfaces.Actions;
import br.com.mobile.pages.BoasVindasPage;
import br.com.mobile.reports.LogReport;

public class ActionsBoasVindas implements Actions {
	
	private BoasVindasPage boasVindasPage = new BoasVindasPage();
	
	@Override
	public void validarTextoPagina(String textoEsperado, String mensagem) {
		
		LogReport.passFail(boasVindasPage.textoExibidoPagina(textoEsperado), mensagem);
	}
	
	@Override
	public void clicarBotao(String botao) {
		
		boasVindasPage.touchActionDownDisplayed(botao);
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
	
	@Override
	public void instalarApp() {
		
		boasVindasPage.setupEnviroment();
	}
	
	@Override
	public void finalizarApp() throws Exception {
		
		boasVindasPage.driverClose();
	}
	
	@Override
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

	@Override
	public void deslizarParaEsquerdaElementoVisivel(String elemento) {
		
		boasVindasPage.deslizarParaEsquerdaElementoVisivel(elemento);
	}

	@Override
	public void deslizarParaDireitaElementoVisivel(String elemento) {
		
		boasVindasPage.deslizarParaEsquerdaElementoVisivel(elemento);
	}

	@Override
	public void deslizarParaDireitaTextoVisivel(String texto) {
		
		boasVindasPage.deslizarParaDireitaTextoVisivel(texto);
	}

	@Override
	public void deslizarParaEsquerdaTextoVisivel(String texto) {
		
		boasVindasPage.deslizarParaEsquerdaTextoVisivel(texto);
	}
}
