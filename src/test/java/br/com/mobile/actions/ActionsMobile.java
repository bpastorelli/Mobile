package br.com.mobile.actions;

import br.com.mobile.pages.BoasVindasPage;
import br.com.mobile.reports.LogReport;

public class ActionsMobile {
	
	private BoasVindasPage boasVindasPage = new BoasVindasPage();
	
	public void validarTextoPagina(String texto) {
		
		LogReport.passFail(boasVindasPage.textoExibidoPagina(texto), "Carregamento do aplicatico");
	}
	
	public void clicarBotao(String botao) {
		
		boasVindasPage.clicarBotao(botao);
	}
	
	public void deslizarParaEsquerda(int qtde) throws Exception {
		
		boasVindasPage.deslizarParaEsquerda(qtde);
	}

}
