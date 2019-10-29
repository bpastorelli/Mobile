package br.com.mobile.pages.android;

import org.openqa.selenium.By;

import br.com.mobile.implementations.BasePageAndroid;
import br.com.mobile.interfaces.Page;

public class MinhaContaPage extends BasePageAndroid implements Page {

	public MinhaContaPage() {
		
		this.addElement("sair", By.id("com.mercadolibre:id/my_account_user_footer_image"));
		this.addElement("SIM, SAIR", By.id("android:id/button1"));
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
	public void selecionarItemListaSuspensa(String name, String texto, String message) {
		
		selectItemList(name, texto);
	}

	@Override
	public void deslizarParaBaixoTextoVisivel(String texto) {
		
		touchActionDownTextDisplayed(texto, "Texto esperado " + texto);
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

}
