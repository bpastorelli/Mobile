package br.com.mobile.actions;

import static org.junit.Assert.assertTrue;

import br.com.mobile.controllers.GlobalStepsController;
import br.com.mobile.interfaces.Actions;
import br.com.mobile.pages.ContinuarPage;
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
		
		logarPage.digitarTexto(name, value);
	}

	@Override
	public void selecionarItemListaSuspensa(String name, String value, String message) {
		
		logarPage.selecionarItemListaSuspensa(name, value, message);
	}

	@Override
	public void deslizarParaBaixoTextoVisivel(String texto) {
		
		logarPage.deslizarParaDireitaTextoVisivel(texto);
	}
	

	@Override
	public Boolean textoExibidoPagina(String texto) {
		
		return controller.getPage(new LogarPage()).textoExibidoPagina(texto);
	}
	
	public void logar() {
		
		controller.getPage(new InicialPage()).ifPopupIsPresent("Tenemos una nueva versión", "MAIS TARDE");
		if(controller.getPage(new InicialPage()).textoExibidoPagina("¿En dónde estás?"))		
			controller.getPage(new InicialPage()).selecionarItemListaSuspensa("paises", "Brasil", "");
		
		controller.getPage(new InicialPage()).ifPopupIsPresent("Tenemos una nueva versión", "MAIS TARDE");
		controller.getPage(new InicialPage()).textoExibidoPagina("¿Qué estás esperando?");
		controller.getPage(new InicialPage()).clicarBotao("Já tenho conta");
		
		if(controller.getPage(new ContinuarPage()).textoExibidoPagina("Continue with"))			
			controller.getPage(new ContinuarPage()).clicarBotao("NENHUMA DAS ALTERNATIVAS ACIMA");
		
		if(controller.getPage(new LogarPage()).textoExibidoPagina("E-mail ou usuário")) {
			controller.getPage(new LogarPage()).digitarTexto("e-mail", "brunopastorelli@hotmail.com");
			controller.getPage(new LogarPage()).clicarBotao("Continuar");
		}
		
		controller.getPage(new LogarPage()).textoExibidoPagina("Senha");
		controller.getPage(new LogarPage()).digitarTexto("senha", "sid04197");
		controller.getPage(new LogarPage()).clicarBotao("Entrar");
		
		if(inicialPage.textoExibidoPagina("Instale a nova versão disponível")) {
			controller.getPage(new LogarPage()).clicarBotao("MAIS TARDE");
		}
		
		assertTrue(controller.getPage(new LogarPage()).textoExibidoPagina("Pagar com QR"));
	}

	@Override
	public void menu() {
		
		controller.getPage(new LogarPage()).clicarBotao("menu");
	}

}
