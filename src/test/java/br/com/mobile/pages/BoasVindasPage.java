package br.com.mobile.pages;

import org.openqa.selenium.By;

import br.com.mobile.implementations.BasePageAndroid;
import br.com.mobile.interfaces.Page;
import br.com.mobile.reports.LogReport;

public class BoasVindasPage extends BasePageAndroid implements Page {
	
	public BoasVindasPage() {
		
		this.addElement("PULAR", By.id("tutorial_fragment_skip_button"));
		this.addElement("IR PARA O APLICATIVO", By.id("tutorial_fragment_skip_button"));
	}
	
	@Override
	public boolean textoExibidoPagina(String texto) {
		
		return waitText(texto);
	}
	
	@Override
	public void clicarBotao(String label) {
		
		clickElementByMapElements(label);
	}
	
	@Override
	public void deslizarParaEsquerda(int qtde) throws Exception {
		
		for(int i = 0; i < qtde; i++) {			
			touchActionLeft();
			LogReport.info("Deslizo a esquerda, visualizo a tela " + (i + 1) + " de " + qtde + ".");
		}
	}

	@Override
	public void deslizarParaDireia(int qtde) throws Exception {
		
		for(int i = 0; i < qtde; i++) {			
			touchActionRight();
			LogReport.info("Deslizo a direita, visualizo a tela " + (qtde - i) + " de " + qtde + ".");
		}
	}
	
	@Override
	public void digitarTexto(String name, String texto) {
		
		setText(name, texto);
	}
	

	@Override
	public void deslizarParaEsquerda() {
				
		touchActionLeft();
	}

	@Override
	public void deslizarParaDireia() {
		
		touchActionRight();
	}

	@Override
	public void deslizarParaCima(Integer qtde) {
		
		touchActionTop(qtde);
	}

	@Override
	public void deslizarParaBaixo(Integer qtde) {
		
		touchActionDown(qtde);
	}

	@Override
	public void deslizarParaEsquerdaElementoVisivel(String name) {
		
		touchActionLeftDisplayed(name, "");
	}

	@Override
	public void deslizarParaDireitaElementoVisivel(String name){
		
		touchActionRightDisplayed(name, "");
	}

	@Override
	public void deslizarParaDireitaTextoVisivel(String texto) {
		
		touchActionRightTextDisplayed(texto, "");
	}

	@Override
	public void deslizarParaEsquerdaTextoVisivel(String texto) {
		
		touchActionLeftTextDisplayed(texto, "");
	}

}
