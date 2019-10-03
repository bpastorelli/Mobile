package br.com.mobile.pages;

import org.openqa.selenium.By;

import br.com.mobile.implementation.BasePageAndroid;

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
		
		touchDownDisplayed(label);
		clickElementByMapElements(label);
	}

	@Override
	public void digitarTexto(String name, String texto) {
		
		setText(name, texto);
	}

}
