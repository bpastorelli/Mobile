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
		clickElementByMapElements(label);
	}

	@Override
	public void digitarTexto(String name, String texto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deslizarParaEsquerda() throws Exception {
		// TODO Auto-generated method stub
		
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
	public void deslizarParaDireia() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deslizarParaCima(Integer qtde) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deslizarParaBaixo(Integer qtde) {
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
	public void deslizarParaBaixoTextoVisivel(String texto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selecionarItemListaSuspensa(String name, String texto, String message) {
		
		selectItemList(name, texto);
	}

	
	
}
