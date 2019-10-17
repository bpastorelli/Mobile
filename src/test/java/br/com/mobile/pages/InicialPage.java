package br.com.mobile.pages;

import org.openqa.selenium.By;

import br.com.mobile.implementations.BasePageAndroid;
import br.com.mobile.interfaces.Page;

public class InicialPage extends BasePageAndroid implements Page {

	public InicialPage() {
		
		this.addElement("Já tenho conta", By.id("home_onboarding_already_has_account_button"));
		this.addElement("MÁS TARDE", By.id("android:id/button2"));
		this.addElement("paises", By.xpath("//android.widget.TextView"));
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
		
		for(int i=0; i < qtde; i++) {
			
			touchActionRight();
		}
	}

	@Override
	public void deslizarParaEsquerda(int qtde) throws Exception {
		
		for(int i=0; i < qtde; i++) {
			
			touchActionLeft();
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
	
	public void naoInstalarNovaVersao(String name) {
		
		boolean presence = false;
		
		int i = 0;
		do {
			i++;
			wait(1);
			if(textIsPresent(name)) {
				clickElementByMapElements(name);
				presence = true;
			}
		}while(!presence && i < 5);
		
	}
	
	public void naoInstalarNovaVersao(String mensagem, String name) {
		
		boolean presence = false;
		
		int i = 0;
		do {
			i++;
			wait(1);
			if(textIsPresent(mensagem)) {
				clickElementByMapElements(name);
				if(!textIsPresent(mensagem))
					presence = true;
			}
		}while(!presence && i < 5);
		
	}

	@Override
	public void selecionarItemListaSuspensa(String name, String texto, String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deslizarParaBaixoTextoVisivel(String texto) {
		// TODO Auto-generated method stub
		
	}

}
