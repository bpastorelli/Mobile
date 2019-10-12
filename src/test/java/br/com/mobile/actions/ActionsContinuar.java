package br.com.mobile.actions;

import br.com.mobile.interfaces.Actions;
import br.com.mobile.pages.ContinuarPage;
import br.com.mobile.reports.LogReport;

public class ActionsContinuar implements Actions {
	
	private ContinuarPage continuarPage = new ContinuarPage();
	
	@Override
	public void validarTextoPagina(String textoEsperado, String mensagem) {
		
		LogReport.passFail(continuarPage.textoExibidoPagina(textoEsperado), mensagem);
	}
	
	@Override
	public void clicarBotao(String botao) {
		
		continuarPage.clicarBotao(botao);
	}
	
	@Override
	public void deslizarParaEsquerda(int qtde) throws Exception {
		
		continuarPage.deslizarParaEsquerda(qtde);
	}
	
	@Override
	public void deslizarParaDireita(int qtde) throws Exception {
		
		continuarPage.deslizarParaDireia(qtde);
	}
	
	@Override
	public void instalarApp() {
		
		continuarPage.setupEnviroment();
	}
	
	@Override
	public void finalizarApp() throws Exception {
		
		continuarPage.driverClose();
	}
	
	@Override
	public void desinstalarApp() {
		
		continuarPage.uninstallApp();
	}

	@Override
	public void deslizarParaCima(int qtde) {
		
		continuarPage.deslizarParaCima(qtde);
	}

	@Override
	public void deslizarParaBaixo(int qtde) {
		
		continuarPage.deslizarParaBaixo(qtde);
	}

	@Override
	public void deslizarParaEsquerdaElementoVisivel(String elemento) {
		
		continuarPage.deslizarParaEsquerdaElementoVisivel(elemento);
	}

	@Override
	public void deslizarParaDireitaElementoVisivel(String elemento) {
		
		continuarPage.deslizarParaEsquerdaElementoVisivel(elemento);
	}

	@Override
	public void deslizarParaDireitaTextoVisivel(String texto) {
		
		continuarPage.deslizarParaDireitaTextoVisivel(texto);
	}

	@Override
	public void deslizarParaEsquerdaTextoVisivel(String texto) {
		
		continuarPage.deslizarParaEsquerdaTextoVisivel(texto);
	}

	@Override
	public void digitarTexto(String name, String value) {
		// TODO Auto-generated method stub
		
	}
}
