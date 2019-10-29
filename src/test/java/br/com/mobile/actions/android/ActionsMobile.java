package br.com.mobile.actions.android;

import br.com.mobile.controllers.GlobalStepsController;
import br.com.mobile.pages.android.CarrinhoPage;
import br.com.mobile.pages.android.ContinuarPage;
import br.com.mobile.pages.android.InicialPage;
import br.com.mobile.pages.android.LogarPage;
import br.com.mobile.pages.android.MenuPage;
import br.com.mobile.pages.android.MinhaContaPage;
import br.com.mobile.pages.android.PesquisaPage;
import br.com.mobile.reports.LogReport;

public class ActionsMobile {
	
	private GlobalStepsController controller = new GlobalStepsController();
	
	public void logar(String usuario, String senha) {
		
		controller.getPage(new InicialPage()).ifPopupIsPresent("Acessar a minha conta", "Acessar a minha conta", 2);
		controller.getPage(new InicialPage()).ifPopupIsPresent("Instale a nova versão disponível", "MAIS TARDE", 2);
		if(controller.getPage(new InicialPage()).textoExibidoPagina("Onde você está?", 2))		
			controller.getPage(new InicialPage()).selecionarItemListaSuspensa("paises", "Brasil", "Clicar no país de localização");
		
		controller.getPage(new InicialPage()).ifPopupIsPresent("Instale a nova versão disponível", "MAIS TARDE", 2);
		controller.getPage(new InicialPage()).ifPopupIsPresent("O que está esperando?", "Já tenho conta", 2);
		controller.getPage(new ContinuarPage()).ifPopupIsPresent("Continuar com", "NENHUMA DAS ALTERNATIVAS ACIMA", 2);			
		
		if(controller.getPage(new LogarPage()).textoExibidoPagina("E-mail ou usuário", 2)) {
			controller.getPage(new LogarPage()).digitarTexto("e-mail", usuario);
			controller.getPage(new LogarPage()).clicarBotao("Continuar");
		}
		
		controller.getPage(new LogarPage()).textoExibidoPagina("Senha", 2);
		controller.getPage(new LogarPage()).digitarTexto("senha", senha);
		controller.getPage(new LogarPage()).clicarBotao("Entrar");
		controller.getPage(new InicialPage()).ifPopupIsPresent("Instale a nova versão disponível", "MAIS TARDE", 2);
		controller.getPage(new InicialPage()).ifPopupIsPresent("Sign in easily across devices", "NUNCA", 2);
		
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
		
		LogReport.passFail(controller.getPage(new PesquisaPage()).textoExibidoPagina(esperado), "Nova pesquisa de produto " + produto);
	}

	public void adicionarProdutoCarrinho(String esperado) {
		
		controller.getPage(new CarrinhoPage()).deslizarParaBaixoElementoVisivel("adicionarCarrinho");
		controller.getPage(new CarrinhoPage()).clicarBotao("adicionarCarrinho");
		
		LogReport.passFail(controller.getPage(new PesquisaPage()).textoExibidoPagina(esperado, 5), "Adicionar produto ao carrinho");
	}
	
	public void removerProdutoCarrinho() {
		
		controller.getPage(new CarrinhoPage()).deslizarParaCimaElementoVisivel("carrinho");
		controller.getPage(new InicialPage()).clicarBotao("menu");
		controller.getPage(new CarrinhoPage()).clicarBotao("carrinho");
		controller.getPage(new CarrinhoPage()).clicarBotao("menuCarrinho");
		controller.getPage(new CarrinhoPage()).selecionarItemListaSuspensa("opcoesCarrinho", "Excluir produto", "");
		
		LogReport.passFail(controller.getPage(new CarrinhoPage()).textoExibidoPagina("O seu carrinho está vazio"), "Remover produto do carrinho");
	}
	
	public void logout() {
		
		controller.getPage(new InicialPage()).clicarBotao("menu");
		controller.getPage(new MenuPage()).clicarBotao("Minha conta");
		controller.getPage(new MinhaContaPage()).clicarBotao("sair");
		controller.getPage(new MinhaContaPage()).ifPopupIsPresent("Deseja sair da sua conta?", "SIM, SAIR");
		
		LogReport.passFail(controller.getPage(new InicialPage()).textoExibidoPagina("Acesse sua conta"), "Logout");
	}

}
