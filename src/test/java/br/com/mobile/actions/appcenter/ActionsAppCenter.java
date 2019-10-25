package br.com.mobile.actions.appcenter;

import static org.junit.Assert.assertTrue;

import br.com.mobile.controllers.GlobalStepsController;
import br.com.mobile.pages.appcenter.CarrinhoPage;
import br.com.mobile.pages.appcenter.ContinuarPage;
import br.com.mobile.pages.appcenter.InicialPage;
import br.com.mobile.pages.appcenter.LogarPage;
import br.com.mobile.pages.appcenter.PesquisaPage;

public class ActionsAppCenter {
	
	private GlobalStepsController controller = new GlobalStepsController();
	
	public void logar(String usuario, String senha) {
		
		controller.getPage(new InicialPage()).ifPopupIsPresent("Tenemos una nueva versión", "MAIS TARDE");
		if(controller.getPage(new InicialPage()).textoExibidoPagina("¿En dónde estás?"))		
			controller.getPage(new InicialPage()).selecionarItemListaSuspensa("paises", "Brasil", "");
		
		controller.getPage(new InicialPage()).ifPopupIsPresent("Tenemos una nueva versión", "MAIS TARDE");
		controller.getPage(new InicialPage()).textoExibidoPagina("¿Qué estás esperando?");
		controller.getPage(new InicialPage()).clicarBotao("Já tenho conta");
		
		if(controller.getPage(new ContinuarPage()).textoExibidoPagina("Continue with"))			
			controller.getPage(new ContinuarPage()).clicarBotao("NENHUMA DAS ALTERNATIVAS ACIMA");
		
		if(controller.getPage(new LogarPage()).textoExibidoPagina("E-mail ou usuário")) {
			controller.getPage(new LogarPage()).digitarTexto("e-mail", usuario);
			controller.getPage(new LogarPage()).clicarBotao("Continuar");
		}
		
		controller.getPage(new LogarPage()).textoExibidoPagina("Senha");
		controller.getPage(new LogarPage()).digitarTexto("senha", senha);
		controller.getPage(new LogarPage()).clicarBotao("Entrar");
		
		if(controller.getPage(new LogarPage()).textoExibidoPagina("Instale a nova versão disponível")) {
			controller.getPage(new LogarPage()).clicarBotao("MAIS TARDE");
		}
		
		controller.getPage(new InicialPage()).ifPopupIsPresent("Sign in easily across devices", "NUNCA");
		
		assertTrue(controller.getPage(new LogarPage()).textoExibidoPagina("Pagar com QR"));
	}
	
	public void pesquisaProduto(String produto, String descricao, String esperado) {
		
		controller.getPage(new PesquisaPage()).clicarBotao("Buscar");
		controller.getPage(new PesquisaPage()).digitarTexto("txtBusca", produto);
		controller.getPage(new PesquisaPage()).selecionarItemListaSuspensa("produtos", produto, "");
		controller.getPage(new PesquisaPage()).deslizarParaBaixoTextoVisivel(descricao);
		controller.getPage(new PesquisaPage()).selecionarItemListaSuspensa("produtos filtrados", descricao, "");
		assertTrue(controller.getPage(new PesquisaPage()).textoExibidoPagina(esperado));
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
