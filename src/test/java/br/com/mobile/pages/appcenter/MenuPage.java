package br.com.mobile.pages.appcenter;

import org.openqa.selenium.By;

import br.com.mobile.implementations.BasePageAppCenter;
import br.com.mobile.interfaces.Page;

public class MenuPage extends BasePageAppCenter implements Page {
	
	public MenuPage() {
		
	}

	@Override
	public boolean textoExibidoPagina(String texto) {

		return waitText(texto);		
	}

	@Override
	public void clicarBotao(String label) {
		
		this.addElement(label, By.xpath("//android.widget.TextView[@text=" + label.replace("opcao", "") + "]"));
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
