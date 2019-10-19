package br.com.mobile.actions;

import br.com.mobile.controllers.GlobalStepsController;
import br.com.mobile.enums.Page;
import br.com.mobile.interfaces.Actions;
import br.com.mobile.pages.InicialPage;
import br.com.mobile.pages.LogarPage;
import br.com.mobile.reports.LogReport;
import static org.junit.Assert.*;

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
		
		return logarPage.textoExibidoPagina(texto);
	}
	
	public void logar() {
		
		inicialPage.naoInstalarNovaVersao("Tenemos una nueva versión", "MAIS TARDE");
		if(controller.getAction(Page.INICIAL).textoExibidoPagina("¿En dónde estás?")) {
			controller.getAction(Page.INICIAL).validarTextoPagina("¿En dónde estás?", "");			
			controller.getAction(Page.INICIAL).selecionarItemListaSuspensa("paises", "Brasil", "");
		}
		
		inicialPage.naoInstalarNovaVersao("Tenemos una nueva versión", "MAIS TARDE");
		controller.getAction(Page.INICIAL).validarTextoPagina("¿Qué estás esperando?", "");
		controller.getAction(Page.INICIAL).clicarBotao("Já tenho conta");
		
		if(controller.getAction(Page.LOGAR).textoExibidoPagina("Continue with")) {			
			controller.getAction(Page.CONTINUAR).validarTextoPagina("Continuar com", "");
			controller.getAction(Page.CONTINUAR).clicarBotao("NENHUMA DAS ALTERNATIVAS ACIMA");
		}
		
		if(controller.getAction(Page.LOGAR).textoExibidoPagina("E-mail ou usuário")) {
			controller.getAction(Page.LOGAR).digitarTexto("e-mail", "brunopastorelli@hotmail.com");
			controller.getAction(Page.LOGAR).clicarBotao("Continuar");
		}
		
		controller.getAction(Page.LOGAR).validarTextoPagina("Senha", null);
		controller.getAction(Page.LOGAR).digitarTexto("senha", "sid04197");
		controller.getAction(Page.LOGAR).clicarBotao("Entrar");
		
		if(inicialPage.textoExibidoPagina("Instale a nova versão disponível")) {
			controller.getAction(Page.PESQUISA).clicarBotao("MAIS TARDE");
		}
		
		assertTrue(controller.getAction(Page.PESQUISA).textoExibidoPagina("Pagar com QR"));
		
	}

	@Override
	public void menu() {
		
		inicialPage.clicarBotao("menu");
	}

}
