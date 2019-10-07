package br.com.mobile.pages;

import org.openqa.selenium.By;

import br.com.mobile.implementations.BasePageAndroid;
import br.com.mobile.interfaces.Page;
import br.com.mobile.reports.LogReport;

public class ConfigurationPage extends BasePageAndroid implements Page {
	
	public ConfigurationPage() {
		
		this.addElement("Não quero perder nada", By.id("notifications_fragment_all_news_radio_button"));
		this.addElement("Só as mais importantes", By.id("notifications_fragment_important_news_radio_button"));
		this.addElement("Apenas grandes acontecimentos", By.id("notifications_fragment_urgent_news_radio_button"));
		this.addElement("Não receber nenhuma", By.id("notifications_fragment_no_news_radio_button"));
		this.addElement("Som", By.id("notifications_fragment_sound_switch"));
		this.addElement("Vibração", By.id("notifications_fragment_vibration_switch"));
		this.addElement("IR PARA A TELA INICIAL", By.id("notifications_fragment_button"));
	}

	@Override
	public boolean textoExibidoPagina(String texto) {
		
		return waitText(texto);
	}

	@Override
	public void clicarBotao(String label) {
		
		touchActionDownDisplayed(label);
		clickElementByMapElements(label);
	}

	@Override
	public void digitarTexto(String name, String texto) {
		
		setText(name, texto);
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
	public void deslizarParaEsquerda() {
		
		touchActionLeft();
	}

	@Override
	public void deslizarParaDireia() {
		
		touchActionRight();
	}

	@Override
	public void deslizarParaDireia(int qtde) throws Exception {
		
		for(int i=0; i < qtde; i++) {
			touchActionRight();
			LogReport.info("Deslizo a direita, visualizo a tela " + (qtde - i) + " de " + qtde + ".");
		}
	}

	@Override
	public void deslizarParaEsquerda(int qtde) throws Exception {
		
		for(int i=0; i < qtde; i++) {
			touchActionLeft();
			LogReport.info("Deslizo a esquerda, visualizo a tela " + (qtde - i) + " de " + qtde + ".");
		}		
	}

	@Override
	public void deslizarParaEsquerdaElementoVisivel(String name) {
		
		
	}

	@Override
	public void deslizarParaDireitaElementoVisivel(String name) {
		
		
	}

	@Override
	public void deslizarParaDireitaTextoVisivel(String texto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deslizarParaEsquerdaTextoVisivel(String texto) {
		// TODO Auto-generated method stub
		
	}

}
