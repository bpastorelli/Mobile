package br.com.mobile.actions;

import br.com.mobile.interfaces.Actions;
import br.com.mobile.pages.InicialPage;
import br.com.mobile.reports.LogReport;

public class ActionsInicial implements Actions {
	
	private InicialPage inicialPage = new InicialPage(); 
	
	@Override
	public void validarTextoPagina(String textoEsperado, String mensagem) {
		
		LogReport.passFail(inicialPage.textoExibidoPagina(textoEsperado), mensagem);
	}
	
	@Override
	public void clicarBotao(String botao) {
		
		inicialPage.touchActionDownDisplayed(botao);
		inicialPage.clicarBotao(botao);
	}
	
	@Override
	public void deslizarParaEsquerda(int qtde) throws Exception {
		
		inicialPage.deslizarParaEsquerda(qtde);
	}
	
	@Override
	public void deslizarParaDireita(int qtde) throws Exception {
		
		inicialPage.deslizarParaDireia(qtde);
	}
	
	@Override
	public void instalarApp() {
		
		inicialPage.setupEnviroment();
	}
	
	@Override
	public void finalizarApp() throws Exception {
		
		inicialPage.driverClose();
	}
	
	@Override
	public void desinstalarApp() {
		
		inicialPage.uninstallApp();
	}

	@Override
	public void deslizarParaCima(int qtde) {
		
		inicialPage.deslizarParaCima(qtde);
	}

	@Override
	public void deslizarParaBaixo(int qtde) {
		
		inicialPage.deslizarParaBaixo(qtde);
	}

	@Override
	public void deslizarParaEsquerdaElementoVisivel(String elemento) {
		
		inicialPage.deslizarParaEsquerdaElementoVisivel(elemento);
	}

	@Override
	public void deslizarParaDireitaElementoVisivel(String elemento) {
		
		inicialPage.deslizarParaEsquerdaElementoVisivel(elemento);
	}

	@Override
	public void deslizarParaDireitaTextoVisivel(String texto) {
		
		inicialPage.deslizarParaDireitaTextoVisivel(texto);
	}

	@Override
	public void deslizarParaEsquerdaTextoVisivel(String texto) {
		
		inicialPage.deslizarParaEsquerdaTextoVisivel(texto);
	}

	@Override
	public void digitarTexto(String name, String value) {
		
		inicialPage.digitarTexto(name, value);
	}
	
	public void naoInstalarNovaVersao(String mensagem, String opcao) {
				
		inicialPage.naoInstalarNovaVersao(mensagem, opcao);
	}

	@Override
	public void selecionarItemListaSuspensa(String name, String value, String message) {
		
		inicialPage.selecionarItemListaSuspensa(name, value, message);
	}

	@Override
	public void deslizarParaBaixoTextoVisivel(String texto) {
		
		inicialPage.touchActionDownTextDisplayed(texto, null);
	}

	@Override
	public Boolean textoExibidoPagina(String texto) {

		return inicialPage.waitText(texto);
	}
}
