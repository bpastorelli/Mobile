package br.com.mobile.actions;

import br.com.mobile.interfaces.Actions;
import br.com.mobile.pages.PesquisaPage;
import br.com.mobile.reports.LogReport;

public class ActionsPesquisa implements Actions {
	
	private PesquisaPage pesquisaPage = new PesquisaPage();
	
	@Override
	public void validarTextoPagina(String textoEsperado, String mensagem) {
		
		LogReport.passFail(pesquisaPage.textoExibidoPagina(textoEsperado), mensagem);
	}
	
	@Override
	public void clicarBotao(String botao) {
		
		//pesquisaPage.touchActionDownDisplayed(botao);
		pesquisaPage.clicarBotao(botao);
	}
	
	@Override
	public void deslizarParaEsquerda(int qtde) throws Exception {
		
		pesquisaPage.deslizarParaEsquerda(qtde);
	}
	
	@Override
	public void deslizarParaDireita(int qtde) throws Exception {
		
		pesquisaPage.deslizarParaDireia(qtde);
	}
	
	@Override
	public void instalarApp() {
		
		pesquisaPage.setupEnviroment();
	}
	
	@Override
	public void finalizarApp() throws Exception {
		
		pesquisaPage.driverClose();
	}
	
	@Override
	public void desinstalarApp() {
		
		pesquisaPage.uninstallApp();
	}

	@Override
	public void deslizarParaCima(int qtde) {
		
		pesquisaPage.deslizarParaCima(qtde);
	}

	@Override
	public void deslizarParaBaixo(int qtde) {
		
		pesquisaPage.deslizarParaBaixo(qtde);
	}

	@Override
	public void deslizarParaEsquerdaElementoVisivel(String elemento) {
		
		pesquisaPage.deslizarParaEsquerdaElementoVisivel(elemento);
	}

	@Override
	public void deslizarParaDireitaElementoVisivel(String elemento) {
		
		pesquisaPage.deslizarParaEsquerdaElementoVisivel(elemento);
	}

	@Override
	public void deslizarParaDireitaTextoVisivel(String texto) {
		
		pesquisaPage.deslizarParaDireitaTextoVisivel(texto);
	}

	@Override
	public void deslizarParaEsquerdaTextoVisivel(String texto) {
		
		pesquisaPage.deslizarParaEsquerdaTextoVisivel(texto);
	}

	@Override
	public void digitarTexto(String name, String value) {
		
		pesquisaPage.setText(name, value);
	}

	@Override
	public void selecionarItemListaSuspensa(String name, String value, String message) {
		
		pesquisaPage.selecionarItemListaSuspensa(name, value, message);
	}

	@Override
	public void deslizarParaBaixoTextoVisivel(String texto) {
		
		pesquisaPage.deslizarParaBaixoTextoVisivel(texto);
	}
	
}