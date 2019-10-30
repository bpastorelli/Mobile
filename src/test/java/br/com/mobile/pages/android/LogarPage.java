package br.com.mobile.pages.android;

import org.openqa.selenium.By;

import br.com.mobile.implementations.BasePageAndroid;
import br.com.mobile.interfaces.Page;

public class LogarPage extends BasePageAndroid implements Page {

	public LogarPage() {
		
		this.addElement("e-mail", By.id("ui_text_field_input")); 	
		this.addElement("Continuar", By.id("login_continueButton"));
		this.addElement("senha", By.id("ui_text_field_input"));
		this.addElement("Entrar", By.id("login_ingresarButton"));
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
		
		// TODO Auto-generated method stub
	}

	@Override
	public void deslizarParaEsquerda(int qtde) throws Exception {
		
		// TODO Auto-generated method stub
	}

	@Override
	public void deslizarParaEsquerdaElementoVisivel(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deslizarParaDireitaElementoVisivel(String name) {
		
		touchActionRightDisplayed(name, "");
	}

	@Override
	public void deslizarParaDireitaTextoVisivel(String texto) {
		
		touchActionDownTextDisplayed(texto, null);
	}

	@Override
	public void deslizarParaEsquerdaTextoVisivel(String texto) {
		
		touchActionLeftTextDisplayed(texto, "");
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
	public void ifPopupIsPresent(String mensagem, String name) {
		
		clickByText(mensagem, name);
	}

	@Override
	public void deslizarParaBaixoElementoVisivel(String name) {
		
		touchActionDownDisplayed(name);
	}

	@Override
	public void deslizarParaCimaElementoVisivel(String name) {
		
		touchActionTopDisplayed(name);
	}

	@Override
	public boolean textoExibidoPagina(String texto, Integer time) {
		
		return waitText(texto, time);
	}

	@Override
	public void ifPopupIsPresent(String mensagem, String name, Integer time) {
		
		clickByText(mensagem, name, time);
	}
	
	@Override
	public void voltar(String texto) {
		
		returnUntilTextDisplayed(texto);
	}

}
