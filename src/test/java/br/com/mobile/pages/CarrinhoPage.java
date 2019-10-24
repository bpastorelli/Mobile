package br.com.mobile.pages;

import org.openqa.selenium.By;

import br.com.mobile.implementations.BasePageAppCenter;
import br.com.mobile.interfaces.Page;

public class CarrinhoPage extends BasePageAppCenter implements Page {

	public CarrinhoPage() {
		
		this.addElement("menuCarrinho", By.id("com.mercadolibre:id/cart_item_options"));
		this.addElement("opcoesCarrinho", By.xpath("//android.widget.TextView"));
		this.addElement("menu", By.xpath("//android.widget.ImageButton[@content-desc=\"Navegar para cima\"]"));
	}
	
	@Override
	public boolean textoExibidoPagina(String texto) {
		
		return waitText(texto);
	}

	@Override
	public void clicarBotao(String label) {
		
		touchActionTopDisplayed(label);
		touchActionDownDisplayed(label);
		clickElementByMapElements(label);
	}

	@Override
	public void digitarTexto(String name, String texto) {
		
		setText(name, texto);
	}

	@Override
	public void deslizarParaEsquerda() throws Exception {
		
		touchActionLeft();
	}

	@Override
	public void deslizarParaDireia(int qtde) throws Exception {
			
		touchActionRight(qtde);
	}

	@Override
	public void deslizarParaEsquerda(int qtde) throws Exception {
		
		for(int i=0; i < qtde; i++) {
			
			touchActionLeft();
		}
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
	public void deslizarParaDireitaElementoVisivel(String name) {
		
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

	@Override
	public void deslizarParaBaixoTextoVisivel(String texto) {
		
		touchActionDownTextDisplayed(texto, "");
	}

	@Override
	public void selecionarItemListaSuspensa(String name, String texto, String message) {
		
		wait(1);
		selectItemList(name, texto);
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
	
}
