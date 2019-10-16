package br.com.mobile.actions;

import br.com.mobile.controllers.GlobalStepsController;
import br.com.mobile.interfaces.Actions;
import br.com.mobile.pages.InicialPage;
import br.com.mobile.pages.LogarPage;
import br.com.mobile.reports.LogReport;

public class ActionsLogar implements Actions {
	
	private LogarPage logarPage = new LogarPage(); 
	
	private InicialPage inicialPage = new InicialPage();
	
	private GlobalStepsController controller = new GlobalStepsController();
	
	@Override
	public void validarTextoPagina(String textoEsperado, String mensagem) {
		
		LogReport.passFail(logarPage.textoExibidoPagina(textoEsperado), mensagem);
	}
	
	@Override
	public void clicarBotao(String botao) {
		
		logarPage.touchActionDownDisplayed(botao);
		logarPage.clicarBotao(botao);
	}
	
	@Override
	public void deslizarParaEsquerda(int qtde) throws Exception {
		
		logarPage.deslizarParaEsquerda(qtde);
	}
	
	@Override
	public void deslizarParaDireita(int qtde) throws Exception {
		
		logarPage.deslizarParaDireia(qtde);
	}
	
	@Override
	public void instalarApp() {
		
		logarPage.setupEnviroment();
	}
	
	@Override
	public void finalizarApp() throws Exception {
		
		logarPage.driverClose();
	}
	
	@Override
	public void desinstalarApp() {
		
		logarPage.uninstallApp();
	}

	@Override
	public void deslizarParaCima(int qtde) {
		
		logarPage.deslizarParaCima(qtde);
	}

	@Override
	public void deslizarParaBaixo(int qtde) {
		
		logarPage.deslizarParaBaixo(qtde);
	}

	@Override
	public void deslizarParaEsquerdaElementoVisivel(String elemento) {
		
		logarPage.deslizarParaEsquerdaElementoVisivel(elemento);
	}

	@Override
	public void deslizarParaDireitaElementoVisivel(String elemento) {
		
		logarPage.deslizarParaEsquerdaElementoVisivel(elemento);
	}

	@Override
	public void deslizarParaDireitaTextoVisivel(String texto) {
		
		logarPage.deslizarParaDireitaTextoVisivel(texto);
	}

	@Override
	public void deslizarParaEsquerdaTextoVisivel(String texto) {
		
		logarPage.deslizarParaEsquerdaTextoVisivel(texto);
	}

	@Override
	public void digitarTexto(String name, String value) {
		
		logarPage.setText(name, value);
	}

	@Override
	public void selecionarItemListaSuspensa(String name, String value, String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deslizarParaBaixoTextoVisivel(String texto) {
		// TODO Auto-generated method stub
		
	}
	
	public void logar() {
		
		inicialPage.naoInstalarNovaVersao("MAIS TARDE");
		controller.getAction("inicial").validarTextoPagina("O que está esperando?", null);
		controller.getAction("inicial").clicarBotao("Já tenho conta");
		controller.getAction("inicial").validarTextoPagina("Continuar com", null);
		controller.getAction("continuar").clicarBotao("NENHUMA DAS ALTERNATIVAS ACIMA");
		controller.getAction("logar").validarTextoPagina("Senha", null);
		controller.getAction("logar").digitarTexto("senha", "sid04197");
		controller.getAction("logar").clicarBotao("Entrar");
		controller.getAction("pesquisa").validarTextoPagina("Pagar com QR", null);
		
	}
}
