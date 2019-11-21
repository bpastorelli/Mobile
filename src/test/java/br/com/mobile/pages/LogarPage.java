package br.com.mobile.pages;

import java.util.List;

import org.openqa.selenium.By;

import br.com.mobile.controllers.SetupController;
import br.com.mobile.interfaces.BasePage;
import br.com.mobile.interfaces.Page;
import io.appium.java_client.MobileElement;

public class LogarPage implements Page {

	private static final BasePage base = SetupController.loadSetup().getBasePage();
	
	public LogarPage() {
		
		base.addElement("e-mail", By.id("ui_text_field_input")); 	
		base.addElement("Continuar", By.id("login_continueButton"));
		base.addElement("senha", By.id("ui_text_field_input"));
		base.addElement("Entrar", By.id("login_ingresarButton"));
	}
	
	@Override
	public boolean textoExibidoPagina(String texto) {

		return base.waitText(texto);
	}

	@Override
	public void clicarBotao(String label) {
		
		base.clickElement(label);
	}

	@Override
	public void clicarBotao(MobileElement element) {
		
		base.clickElement(element);
	}
	
	@Override
	public void digitarTexto(String name, String texto) {
		
		base.setText(name, texto, false);
	}	
	
	@Override
	public void digitarTexto(String name, String texto, Boolean slow) {
		
		base.setText(name, texto, slow);
	}

	@Override
	public void deslizarParaEsquerda() {
		
		base.touchActionLeft();
	}

	@Override
	public void deslizarParaDireia() {
		
		base.touchActionRight();
	}

	@Override
	public void deslizarParaCima(Integer qtde) {
			
		base.touchActionTop(qtde);
	}

	@Override
	public void deslizarParaBaixo(Integer qtde) {
		
		base.touchActionDown(qtde);
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
		
		base.touchActionRightDisplayed(name, "");
	}

	@Override
	public void deslizarParaDireitaTextoVisivel(String texto) {
		
		base.touchActionDownTextDisplayed(texto, null);
	}

	@Override
	public void deslizarParaEsquerdaTextoVisivel(String texto) {
		
		base.touchActionLeftTextDisplayed(texto, "");
	}

	@Override
	public void selecionarItemListaSuspensa(String name, String texto, String message) {
		
		base.selectItemList(name, texto);
	}

	@Override
	public void deslizarParaBaixoTextoVisivel(String texto) {
		
		base.touchActionDownTextDisplayed(texto, "");
	}

	@Override
	public void ifPopupIsPresent(String mensagem, String name) {
		
		base.clickByText(mensagem, name);
	}

	@Override
	public void deslizarParaBaixoElementoVisivel(String name) {
		
		base.touchActionDownDisplayed(name);
	}

	@Override
	public void deslizarParaCimaElementoVisivel(String name) {
		
		base.touchActionTopDisplayed(name);
	}

	@Override
	public boolean textoExibidoPagina(String texto, Integer time) {
		
		return base.waitText(texto, time);
	}

	@Override
	public void ifPopupIsPresent(String mensagem, String name, Integer time) {
		
		base.clickByText(mensagem, name, time);
	}
	
	@Override
	public void voltar(String texto) {
		
		base.returnUntilTextDisplayed(texto);
	}

	@Override
	public void pause(Integer time) {
		
		base.wait(time);
	}
	
	@Override
	public List<MobileElement> retornaElementos(String name) {
		
		return base.getListElements(name);
	}
}
