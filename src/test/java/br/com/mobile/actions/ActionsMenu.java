package br.com.mobile.actions;

import br.com.mobile.interfaces.Actions;
import br.com.mobile.pages.MenuPage;
import br.com.mobile.reports.LogReport;

public class ActionsMenu implements Actions {
	
	private MenuPage menuPage = new MenuPage();
	
	@Override
	public void validarTextoPagina(String textoEsperado, String mensagem) {
		
		LogReport.passFail(menuPage.textoExibidoPagina(textoEsperado), mensagem);
	}

	@Override
	public void clicarBotao(String botao) {
		
		menuPage.clicarBotao(botao);
	}

	@Override
	public void deslizarParaCima(int qtde) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deslizarParaBaixo(int qtde) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deslizarParaEsquerda(int qtde) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deslizarParaDireita(int qtde) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void instalarApp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void desinstalarApp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finalizarApp() throws Exception {
		// TODO Auto-generated method stub
		
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
	public void deslizarParaDireitaTextoVisivel(String texto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deslizarParaEsquerdaTextoVisivel(String texto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deslizarParaBaixoTextoVisivel(String texto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void digitarTexto(String name, String value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selecionarItemListaSuspensa(String name, String value, String message) {
		
		selecionarItemListaSuspensa(name, value, message);
	}

	@Override
	public Boolean textoExibidoPagina(String texto) {
		
		return menuPage.textoExibidoPagina(texto);
	}

	@Override
	public void menu() {
		
		menuPage.clicarBotao("menu");
	}

}
