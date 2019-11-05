package br.com.mobile.pages;

import org.openqa.selenium.By;

import br.com.mobile.controllers.BasePageController;
import br.com.mobile.interfaces.BasePage;
import br.com.mobile.interfaces.Page;

public class InicialPage implements Page {
	
	private static final BasePage base = BasePageController.getBasePage();
	
	public InicialPage() {
		
		base.addElement("NUNCA", By.id("com.google.android.gms:id/credential_save_reject"));
		base.addElement("Já tenho conta", By.id("home_onboarding_already_has_account_button"));
		base.addElement("MAIS TARDE", By.id("android:id/button2"));
		base.addElement("paises", By.xpath("//android.widget.TextView"));
		base.addElement("menu", By.xpath("//android.widget.ImageButton[@content-desc=\"Navegar para cima\"]"));
		base.addElement("Acessar a minha conta", By.id("com.mercadolibre:id/button_footer_secondary"));
	}
	
	@Override
	public boolean textoExibidoPagina(String texto) {

		return base.waitText(texto);
	}

	@Override
	public boolean textoExibidoPagina(String texto, Integer time) {
		
		return base.waitText(texto, time);
	}
	
	@Override
	public void clicarBotao(String label) {
		
		base.clickElementByMapElements(label);
	}

	@Override
	public void digitarTexto(String name, String texto) {
		
		base.setText(name, texto);
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
		
		for(int i=0; i < qtde; i++) {
			
			base.touchActionRight();
		}
	}

	@Override
	public void deslizarParaEsquerda(int qtde) throws Exception {
		
		for(int i=0; i < qtde; i++) {
			
			base.touchActionLeft();
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
		
		base.clickByText(mensagem, name);
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
	public void deslizarParaBaixoElementoVisivel(String name) {
		
		base.touchActionDownDisplayed(name);
	}

	@Override
	public void deslizarParaCimaElementoVisivel(String name) {
		// TODO Auto-generated method stub
		
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
}
