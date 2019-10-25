package br.com.mobile.actions.android;

import static org.junit.Assert.assertTrue;

import br.com.mobile.controllers.GlobalStepsController;
import br.com.mobile.pages.android.CarrinhoPage;
import br.com.mobile.pages.android.ContinuarPage;
import br.com.mobile.pages.android.InicialPage;
import br.com.mobile.pages.android.LogarPage;
import br.com.mobile.pages.android.PesquisaPage;
import br.com.mobile.reports.LogReport;

public class ActionsMobile {
	
	private GlobalStepsController controller = new GlobalStepsController();
	
	public void logar(String usuario, String senha) {
		
		controller.getPage(new InicialPage()).ifPopupIsPresent("Instale a nova versão disponível", "MAIS TARDE", 5);
		if(controller.getPage(new InicialPage()).textoExibidoPagina("Onde você está?", 5))		
			controller.getPage(new InicialPage()).selecionarItemListaSuspensa("paises", "Brasil", "Clicar no país de localização");
		
		controller.getPage(new InicialPage()).ifPopupIsPresent("Instale a nova versão disponível", "MAIS TARDE", 5);
		controller.getPage(new InicialPage()).textoExibidoPagina("O que está esperando?");
		controller.getPage(new InicialPage()).clicarBotao("Já tenho conta");
		
		if(controller.getPage(new ContinuarPage()).textoExibidoPagina("Continuar com"))			
			controller.getPage(new ContinuarPage()).clicarBotao("NENHUMA DAS ALTERNATIVAS ACIMA");
		
		if(controller.getPage(new LogarPage()).textoExibidoPagina("E-mail ou usuário")) {
			controller.getPage(new LogarPage()).digitarTexto("e-mail", usuario);
			controller.getPage(new LogarPage()).clicarBotao("Continuar");
		}
		
		controller.getPage(new LogarPage()).textoExibidoPagina("Senha");
		controller.getPage(new LogarPage()).digitarTexto("senha", senha);
		controller.getPage(new LogarPage()).clicarBotao("Entrar");
		controller.getPage(new InicialPage()).ifPopupIsPresent("Instale a nova versão disponível", "MAIS TARDE", 5);
		controller.getPage(new InicialPage()).ifPopupIsPresent("Sign in easily across devices", "NUNCA", 5);
		
		LogReport.passFail(controller.getPage(new LogarPage()).textoExibidoPagina("Pagar com QR"), "Login com usuário " + usuario);
	}
	
	public void pesquisaProduto(String produto, String descricao, String esperado) {
		
		controller.getPage(new PesquisaPage()).clicarBotao("Buscar");
		controller.getPage(new PesquisaPage()).digitarTexto("txtBusca", produto);
		controller.getPage(new PesquisaPage()).selecionarItemListaSuspensa("produtos", produto, "");
		controller.getPage(new PesquisaPage()).deslizarParaBaixoTextoVisivel(descricao);
		controller.getPage(new PesquisaPage()).selecionarItemListaSuspensa("produtos filtrados", descricao, "");
		LogReport.passFail(controller.getPage(new PesquisaPage()).textoExibidoPagina(esperado), "Pesquisa do produto " + produto);
	}
	
	public void novaPesquisaProduto(String produto, String descricao, String esperado) {
		
		controller.getPage(new PesquisaPage()).clicarBotao("nova pesquisa");
		controller.getPage(new PesquisaPage()).digitarTexto("txtBusca", produto);
		controller.getPage(new PesquisaPage()).selecionarItemListaSuspensa("produtos", produto, "");
		controller.getPage(new PesquisaPage()).deslizarParaBaixoTextoVisivel(descricao);
		controller.getPage(new PesquisaPage()).selecionarItemListaSuspensa("produtos filtrados", descricao, "");
		assertTrue(controller.getPage(new PesquisaPage()).textoExibidoPagina(esperado));
	}

	public void adicionarProdutoCarrinho(String esperado) {
		
		controller.getPage(new CarrinhoPage()).clicarBotao("adicionarCarrinho");
		assertTrue(controller.getPage(new PesquisaPage()).textoExibidoPagina(esperado));
	}
	
	public void removerProdutoCarrinho() {
		
		controller.getPage(new InicialPage()).clicarBotao("menu");
		controller.getPage(new CarrinhoPage()).clicarBotao("carrinho");
		controller.getPage(new CarrinhoPage()).clicarBotao("menuCarrinho");
		controller.getPage(new CarrinhoPage()).selecionarItemListaSuspensa("opcoesCarrinho", "Excluir produto", "");
		assertTrue(controller.getPage(new CarrinhoPage()).textoExibidoPagina("O seu carrinho está vazio"));
	}

}
