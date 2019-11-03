package br.com.mobile.pages.android;

import org.openqa.selenium.By;

import br.com.mobile.implementations.BasePageAndroid;
import br.com.mobile.interfaces.Page;

public class ContinuarPage extends BasePageAndroid implements Page {

	public ContinuarPage() {
		
		this.addElement("NENHUMA DAS ALTERNATIVAS ACIMA", By.id("com.google.android.gms:id/cancel"));
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deslizarParaBaixoTextoVisivel(String texto) {
		// TODO Auto-generated method stub
		
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
	
	@Override
	public void pause(Integer time) {
		
		wait(time);
	}
}
