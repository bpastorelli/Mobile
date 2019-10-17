package br.com.mobile.pages;

import org.openqa.selenium.By;

import br.com.mobile.implementations.BasePageAppCenter;
import br.com.mobile.interfaces.Page;

public class PesquisaPage extends BasePageAppCenter implements Page {

	public PesquisaPage() {
		
		this.addElement("NUNCA", By.id("com.google.android.gms:id/credential_save_reject"));
		this.addElement("Buscar", By.id("com.mercadolibre:id/home_search"));
		this.addElement("txtBusca", By.id("com.mercadolibre:id/search_input_edittext"));
		this.addElement("produtos", By.xpath("//android.widget.TextView"));
		this.addElement("produtos filtrados", By.xpath("//android.widget.TextView"));
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

}
