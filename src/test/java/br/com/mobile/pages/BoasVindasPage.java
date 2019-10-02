package br.com.mobile.pages;

import org.openqa.selenium.By;

import br.com.mobile.reports.LogReport;

public class BoasVindasPage extends BasePage {
	
	public BoasVindasPage() {
		
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
			LogReport.info("Visualizo a tela " + (i + 1) + " de " + qtde + ".");
		}
	}

}
