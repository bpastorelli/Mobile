package br.com.mobile.pages;

import org.openqa.selenium.By;

import br.com.mobile.impl.BasePageAndroid;
import br.com.mobile.reports.LogReport;

public class BoasVindasPage extends BasePageAndroid {
	
	public BoasVindasPage() {
		
		this.addElement("PULAR", By.id("tutorial_fragment_skip_button"));
		this.addElement("IR PARA O APLICATIVO", By.id("tutorial_fragment_skip_button"));
	}
	
	public boolean textoExibidoPagina(String texto) {
		
		return waitText(texto);
	}
	
	public void clicarBotao(String label) {
		
		clickElementByMapElements(label);
	}
	
	public void deslizarParaEsquerda(int qtde) throws Exception {
		
		for(int i = 0; i < qtde; i++) {			
			toucheActionLeft();
			LogReport.info("Deslizo a esquerda, visualizo a tela " + (i + 1) + " de " + qtde + ".");
		}
	}
	
	public void deslizarParaDireita(int qtde) throws Exception {
		
		for(int i = 0; i < qtde; i++) {			
			toucheActionRight();
			LogReport.info("Deslizo a direita, visualizo a tela " + (qtde - i) + " de " + qtde + ".");
		}
	}
}
