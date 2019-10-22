package br.com.mobile.actions;

import br.com.mobile.controllers.GlobalStepsController;
import br.com.mobile.interfaces.Actions;
import br.com.mobile.pages.InicialPage;
import br.com.mobile.reports.LogReport;

public class ActionsInicial implements Actions {
	
	private InicialPage inicialPage = new InicialPage();
	
	private GlobalStepsController controller = new GlobalStepsController();
	
	@Override
	public void validarTextoPagina(String textoEsperado, String mensagem) {
		
		LogReport.passFail(controller.getPage(new InicialPage()).textoExibidoPagina(textoEsperado), mensagem);
	}
	
	@Override
	public void clicarBotao(String botao) {
		
		controller.getPage(new InicialPage()).deslizarParaDireitaElementoVisivel(botao);
		controller.getPage(new InicialPage()).clicarBotao(botao);
	}
	
	@Override
	public void deslizarParaEsquerda(int qtde) throws Exception {
		
		controller.getPage(new InicialPage()).deslizarParaEsquerda(qtde);
	}
	
	@Override
	public void deslizarParaDireita(int qtde) throws Exception {
		
		controller.getPage(new InicialPage()).deslizarParaDireia(qtde);
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
		
		controller.getPage(new InicialPage()).deslizarParaCima(qtde);
	}

	@Override
	public void deslizarParaBaixo(int qtde) {
		
		controller.getPage(new InicialPage()).deslizarParaBaixo(qtde);
	}

	@Override
	public void deslizarParaEsquerdaElementoVisivel(String elemento) {
		
		controller.getPage(new InicialPage()).deslizarParaEsquerdaElementoVisivel(elemento);
	}

	@Override
	public void deslizarParaDireitaElementoVisivel(String elemento) {
		
		controller.getPage(new InicialPage()).deslizarParaEsquerdaElementoVisivel(elemento);
	}

	@Override
	public void deslizarParaDireitaTextoVisivel(String texto) {
		
		controller.getPage(new InicialPage()).deslizarParaDireitaTextoVisivel(texto);
	}

	@Override
	public void deslizarParaEsquerdaTextoVisivel(String texto) {
		
		controller.getPage(new InicialPage()).deslizarParaEsquerdaTextoVisivel(texto);
	}

	@Override
	public void digitarTexto(String name, String value) {
		
		controller.getPage(new InicialPage()).digitarTexto(name, value);
	}

	@Override
	public void selecionarItemListaSuspensa(String name, String value, String message) {
		
		controller.getPage(new InicialPage()).selecionarItemListaSuspensa(name, value, message);
	}

	@Override
	public void deslizarParaBaixoTextoVisivel(String texto) {
		
		controller.getPage(new InicialPage()).deslizarParaBaixoTextoVisivel(texto);
	}

	@Override
	public Boolean textoExibidoPagina(String texto) {

		return controller.getPage(new InicialPage()).textoExibidoPagina(texto);
	}

	@Override
	public void menu() {
		
		controller.getPage(new InicialPage()).clicarBotao("menu");
	}
}
