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
	
	private GlobalStepsController controller = new GlobalStepsController();
	
	@Override
	public void validarTextoPagina(String textoEsperado, String mensagem) {
		
		LogReport.passFail(controller.getPage(new LogarPage()).textoExibidoPagina(textoEsperado), mensagem);
	}
	
	@Override
	public void clicarBotao(String botao) {
		
		controller.getPage(new LogarPage()).deslizarParaBaixoElementoVisivel(botao);
		controller.getPage(new LogarPage()).clicarBotao(botao);
	}
	
	@Override
	public void deslizarParaEsquerda(int qtde) throws Exception {
		
		controller.getPage(new LogarPage()).deslizarParaEsquerda(qtde);
	}
	
	@Override
	public void deslizarParaDireita(int qtde) throws Exception {
		
		controller.getPage(new LogarPage()).deslizarParaDireia(qtde);
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
		
		controller.getPage(new LogarPage()).deslizarParaCima(qtde);
	}

	@Override
	public void deslizarParaBaixo(int qtde) {
		
		controller.getPage(new LogarPage()).deslizarParaBaixo(qtde);
	}

	@Override
	public void deslizarParaEsquerdaElementoVisivel(String elemento) {
		
		controller.getPage(new LogarPage()).deslizarParaEsquerdaElementoVisivel(elemento);
	}

	@Override
	public void deslizarParaDireitaElementoVisivel(String elemento) {
		
		controller.getPage(new LogarPage()).deslizarParaEsquerdaElementoVisivel(elemento);
	}

	@Override
	public void deslizarParaDireitaTextoVisivel(String texto) {
		
		controller.getPage(new LogarPage()).deslizarParaDireitaTextoVisivel(texto);
	}

	@Override
	public void deslizarParaEsquerdaTextoVisivel(String texto) {
		
		controller.getPage(new LogarPage()).deslizarParaEsquerdaTextoVisivel(texto);
	}

	@Override
	public void digitarTexto(String name, String value) {
		
		controller.getPage(new LogarPage()).digitarTexto(name, value);
	}

	@Override
	public void selecionarItemListaSuspensa(String name, String value, String message) {
		
		controller.getPage(new LogarPage()).selecionarItemListaSuspensa(name, value, message);
	}

	@Override
	public void deslizarParaBaixoTextoVisivel(String texto) {
		
		controller.getPage(new LogarPage()).deslizarParaDireitaTextoVisivel(texto);
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
		
		if(controller.getPage(new LogarPage()).textoExibidoPagina("Instale a nova versão disponível")) {
			controller.getPage(new LogarPage()).clicarBotao("MAIS TARDE");
		}
		
		controller.getPage(new InicialPage()).ifPopupIsPresent("Sign in easily across devices", "NUNCA");
		
		assertTrue(controller.getPage(new LogarPage()).textoExibidoPagina("Pagar com QR"));
	}

	@Override
	public void menu() {
		
		controller.getPage(new LogarPage()).clicarBotao("menu");
	}

}
