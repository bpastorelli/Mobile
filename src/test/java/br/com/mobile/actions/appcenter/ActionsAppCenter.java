package br.com.mobile.actions.appcenter;

import static org.junit.Assert.assertTrue;

import br.com.mobile.controllers.PagesController;
import br.com.mobile.pages.CarrinhoPage;
import br.com.mobile.pages.ContinuarPage;
import br.com.mobile.pages.InicialPage;
import br.com.mobile.pages.LogarPage;
import br.com.mobile.pages.PesquisaPage;

public class ActionsAppCenter extends PagesController {
	
	private LogarPage logarPage = new LogarPage();
	
	private InicialPage inicialPage = new InicialPage();
	
	private ContinuarPage continuarPage = new ContinuarPage();
	
	private PesquisaPage pesquisaPage = new PesquisaPage();
	
	private CarrinhoPage carrinhoPage = new CarrinhoPage();
	
	public void logar(String usuario, String senha) {
		
		getPage(this.inicialPage).ifPopupIsPresent("Tenemos una nueva versión", "MAIS TARDE", 5);
		getPage(this.inicialPage).ifPopupIsPresent("Save Mercado Libre password", "NUNCA", 3);
		if(getPage(this.inicialPage).textoExibidoPagina("¿En dónde estás?", 5))		
			getPage(this.inicialPage).selecionarItemListaSuspensa("paises", "Brasil", "");
		
		getPage(this.inicialPage).ifPopupIsPresent("Tenemos una nueva versión", "MAIS TARDE", 5);
		getPage(this.inicialPage).textoExibidoPagina("¿Qué estás esperando?");
		getPage(this.inicialPage).clicarBotao("Já tenho conta");
		
		if(getPage(this.continuarPage).textoExibidoPagina("Continue with"))			
			getPage(this.continuarPage).clicarBotao("NENHUMA DAS ALTERNATIVAS ACIMA");
		
		if(getPage(this.logarPage).textoExibidoPagina("E-mail ou usuário")) {
			getPage(this.logarPage).digitarTexto("e-mail", usuario);
			getPage(this.logarPage).clicarBotao("Continuar");
		}
		
		getPage(this.logarPage).textoExibidoPagina("Senha");
		getPage(this.logarPage).digitarTexto("senha", senha);
		getPage(this.logarPage).clicarBotao("Entrar");
		getPage(this.inicialPage).ifPopupIsPresent("Instale a nova versão disponível", "MAIS TARDE", 5);
		getPage(this.inicialPage).ifPopupIsPresent("Sign in easily across devices", "NUNCA", 5);
		
		assertTrue(getPage(this.logarPage).textoExibidoPagina("Pagar com QR"));
	}
	
	public void pesquisaProduto(String produto, String descricao, String esperado) {
		
		getPage(this.pesquisaPage).clicarBotao("Buscar");
		getPage(this.pesquisaPage).digitarTexto("txtBusca", produto);
		getPage(this.pesquisaPage).selecionarItemListaSuspensa("produtos", produto, "");
		getPage(this.pesquisaPage).deslizarParaBaixoTextoVisivel(descricao);
		getPage(this.pesquisaPage).selecionarItemListaSuspensa("produtos filtrados", descricao, "");
		assertTrue(getPage(this.pesquisaPage).textoExibidoPagina(esperado));
	}
	
	public void novaPesquisaProduto(String produto, String descricao, String esperado) {
		
		getPage(this.pesquisaPage).clicarBotao("nova pesquisa");
		getPage(this.pesquisaPage).digitarTexto("txtBusca", produto);
		getPage(this.pesquisaPage).selecionarItemListaSuspensa("produtos", produto, "");
		getPage(this.pesquisaPage).deslizarParaBaixoTextoVisivel(descricao);
		getPage(this.pesquisaPage).selecionarItemListaSuspensa("produtos filtrados", descricao, "");
		assertTrue(getPage(this.pesquisaPage).textoExibidoPagina(esperado));
	}

	public void adicionarProdutoCarrinho(String esperado) {
		
		getPage(this.carrinhoPage).clicarBotao("adicionarCarrinho");
		assertTrue(getPage(this.pesquisaPage).textoExibidoPagina(esperado));
	}
	
	public void removerProdutoCarrinho() {
		
		getPage(this.inicialPage).clicarBotao("menu");
		getPage(this.carrinhoPage).clicarBotao("carrinho");
		getPage(this.carrinhoPage).clicarBotao("menuCarrinho");
		getPage(this.carrinhoPage).selecionarItemListaSuspensa("opcoesCarrinho", "Excluir produto", "");
		assertTrue(getPage(this.carrinhoPage).textoExibidoPagina("O seu carrinho está vazio"));
	}

}
