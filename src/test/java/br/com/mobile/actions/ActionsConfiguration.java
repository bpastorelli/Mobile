package br.com.mobile.actions;

import br.com.mobile.interfaces.Actions;
import br.com.mobile.pages.ConfigurationPage;
import br.com.mobile.reports.LogReport;

public class ActionsConfiguration implements Actions {
	
	private ConfigurationPage configurationPage = new ConfigurationPage();
	
	public void validarTextoPagina(String textoEsperado, String mensagem) {
		
		LogReport.passFail(configurationPage.textoExibidoPagina(textoEsperado), mensagem);
	}
	
	@Override
	public void clicarBotao(String botao) {
		
		configurationPage.touchActionDownDisplayed(botao);
		configurationPage.clicarBotao(botao);
	}
	
	@Override
	public void deslizarParaCima(int qtde) {
		
		configurationPage.deslizarParaCima(qtde);
	}
	
	@Override
	public void deslizarParaBaixo(int qtde) {
		
		configurationPage.deslizarParaBaixo(qtde);
	}
	
	@Override
	public void instalarApp() {
		
		configurationPage.setupEnviroment();
	}
	
	@Override
	public void finalizarApp() throws Exception {
		
		configurationPage.driverClose();
	}
	
	@Override
	public void desinstalarApp() {
		
		configurationPage.uninstallApp();
	}
	
	public void clicarOpcaoQuantidadeNoticias(String opcao) {
		
		configurationPage.clicarBotao(opcao);
	}
	
	public void clicarSetarTiposAlertas(String tipo) {
		
		configurationPage.clicarBotao(tipo);
	}

	@Override
	public void deslizarParaEsquerda(int qtde) throws Exception {
		
		configurationPage.deslizarParaEsquerda(qtde);
	}

	@Override
	public void deslizarParaDireita(int qtde) throws Exception {
		
		configurationPage.deslizarParaDireia(qtde);
	}

	@Override
	public void deslizarParaEsquerdaElementoVisivel(String elemento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deslizarParaDireitaElementoVisivel(String elemento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deslizarParaDireitaTextoVisivel(String elemento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deslizarParaEsquerdaTextoVisivel(String elemento) {
		// TODO Auto-generated method stub
		
	}
}
