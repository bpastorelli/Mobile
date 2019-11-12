package br.com.mobile.pages;

import java.util.List;

import org.openqa.selenium.By;

import br.com.mobile.controllers.SetupController;
import br.com.mobile.interfaces.BasePage;
import br.com.mobile.interfaces.Page;
import br.com.mobile.utils.Utils;
import io.appium.java_client.MobileElement;

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
		base.addElement("marcas", By.xpath("//android.widget.TextView"));
		base.addElement("modelos", By.xpath("//android.widget.TextView"));
		base.addElement("aplicar", By.id("com.mercadolibre:id/classifieds_homes_filters_location_apply"));
		base.addElement("buscarVeiculo", By.id("com.mercadolibre:id/filter_button_button"));
		base.addElement("reservarVeiculo", By.id("com.mercadolibre:id/vip_on_boarding_dialog_button"));
		base.addElement("favoritar", By.id("com.mercadolibre:id/vip_action_bar_menu_action_bookmark"));
		
	}
	
	@Override
	public boolean textoExibidoPagina(String texto) {

		return base.waitText(texto);
	}

	@Override
	public void clicarBotao(String label) {
		
		if(Utils.isNumeric(label))
			base.addElement(label, By.xpath("//android.widget.RelativeLayout[" + label + "]/android.widget.FrameLayout[2]/android.widget.FrameLayout"));
		base.touchActionDownDisplayed(label);
		base.clickElementByMapElements(label);
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
		
		base.touchActionRight(qtde);
	}

	@Override
	public void deslizarParaEsquerda(int qtde) throws Exception {
		
		base.touchActionLeft(qtde);
	}

	@Override
	public void deslizarParaEsquerdaElementoVisivel(String name) {
		
		base.touchActionLeftDisplayed(name, "");
	}

	@Override
	public void deslizarParaDireitaElementoVisivel(String name) {
		
		base.touchActionLeftDisplayed(name, "");
	}

	@Override
	public void deslizarParaDireitaTextoVisivel(String texto) {
		
		base.touchActionRightTextDisplayed(texto, "");
	}

	@Override
	public void deslizarParaEsquerdaTextoVisivel(String texto) {
		
		base.touchActionLeftTextDisplayed(texto, "");
	}

	@Override
	public void selecionarItemListaSuspensa(String name, String texto, String message) {
		
		base.touchActionDownTextDisplayed(texto, message);
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

	@Override
	public List<MobileElement> retornaElementos(String name) {
		
		return base.getListElements(name);
	}
}
