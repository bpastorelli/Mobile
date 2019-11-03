package br.com.mobile.pages.android;

import org.openqa.selenium.By;

import br.com.mobile.implementations.BasePageAndroid;
import br.com.mobile.interfaces.Page;

public class InicialPage extends BasePageAndroid implements Page {

	public InicialPage() {
		
		this.addElement("NUNCA", By.id("com.google.android.gms:id/credential_save_reject"));
		this.addElement("Já tenho conta", By.id("home_onboarding_already_has_account_button"));
		this.addElement("MAIS TARDE", By.id("android:id/button2"));
		this.addElement("paises", By.xpath("//android.widget.TextView"));
		this.addElement("menu", By.xpath("//android.widget.ImageButton[@content-desc=\"Navegar para cima\"]"));
		this.addElement("Acessar a minha conta", By.id("com.mercadolibre:id/button_footer_secondary"));
	}
	
	@Override
	public boolean textoExibidoPagina(String texto) {

		return waitText(texto);
	}

	@Override
	public boolean textoExibidoPagina(String texto, Integer time) {
		
		return waitText(texto, time);
	}
	
	@Override
	public void clicarBotao(String label) {
		
		clickElementByMapElements(label);
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
	public void deslizarParaDireia(int qtde) throws Exception {
		
		for(int i=0; i < qtde; i++) {
			
			touchActionRight();
		}
	}

	@Override
	public void deslizarParaEsquerda(int qtde) throws Exception {
		
		for(int i=0; i < qtde; i++) {
			
			touchActionLeft();
		}
	}

	@Override
	public void deslizarParaEsquerdaElementoVisivel(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deslizarParaDireitaElementoVisivel(String name) {
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
	public void ifPopupIsPresent(String mensagem, String name) {
		
		clickByText(mensagem, name);
	}
	
	@Override
	public void selecionarItemListaSuspensa(String name, String texto, String message) {
		
		selectItemList(name, texto);
	}

	@Override
	public void deslizarParaBaixoTextoVisivel(String texto) {
		
		touchActionDownTextDisplayed(texto, "");
	}

	@Override
	public void deslizarParaBaixoElementoVisivel(String name) {
		
		touchActionDownDisplayed(name);
	}

	@Override
	public void deslizarParaCimaElementoVisivel(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ifPopupIsPresent(String mensagem, String name, Integer time) {
		
		clickByText(mensagem, name, time);
	}

	@Override
	public void voltar(String texto) {
		
		returnUntilTextDisplayed(texto);
	}

	@Override
	public void pause(Integer time) {
		
		wait(time);
	}
}
