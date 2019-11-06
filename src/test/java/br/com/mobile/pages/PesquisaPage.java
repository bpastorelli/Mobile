package br.com.mobile.pages;

import org.openqa.selenium.By;

import br.com.mobile.controllers.SetupController;
import br.com.mobile.interfaces.BasePage;
import br.com.mobile.interfaces.Page;

public class PesquisaPage implements Page {
	
	private static final BasePage base = SetupController.loadSetup().getBasePage();
	
	public PesquisaPage() {
		
		base.addElement("NUNCA", By.id("com.google.android.gms:id/credential_save_reject"));
		base.addElement("Buscar", By.id("com.mercadolibre:id/home_search"));
		base.addElement("txtBusca", By.id("com.mercadolibre:id/search_input_edittext"));
		base.addElement("produtos", By.xpath("//android.widget.TextView"));
		base.addElement("produtos filtrados", By.xpath("//android.widget.TextView"));
		base.addElement("nova pesquisa", By.id("com.mercadolibre:id/vip_action_bar_menu_action_search"));
		base.addElement("adicionarCarrinho", By.xpath("//android.widget.TextView[@text=\"Adicionar ao carrinho\"]"));
		base.addElement("carrinho", By.id("com.mercadolibre:id/cart_icon"));
		
	}
	
	@Override
	public boolean textoExibidoPagina(String texto) {

		return base.waitText(texto);
	}

	@Override
	public void clicarBotao(String label) {
		
		base.touchActionDownDisplayed(label);
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
		
		base.selectItemList(name, texto);
	}

	@Override
	public void deslizarParaBaixoTextoVisivel(String texto) {
		
		base.touchActionDownTextDisplayed(texto, "Texto esperado " + texto);
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
}
