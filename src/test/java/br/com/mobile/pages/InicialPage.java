package br.com.mobile.pages;

import org.openqa.selenium.By;

import br.com.mobile.implementations.BasePageAndroid;
import br.com.mobile.interfaces.Page;

public class InicialPage extends BasePageAndroid implements Page {

	public InicialPage() {
		
		this.addElement("ENTRAR COM SEU E-MAIL", By.id("login_dialog_uol_button"));
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

}