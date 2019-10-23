package br.com.mobile.actions;

import static org.junit.Assert.assertTrue;

import br.com.mobile.controllers.GlobalStepsController;
import br.com.mobile.interfaces.Actions;
import br.com.mobile.pages.CarrinhoPage;
import br.com.mobile.pages.InicialPage;
import br.com.mobile.pages.PesquisaPage;
import br.com.mobile.reports.LogReport;

public class ActionsPesquisa implements Actions {
	
	private PesquisaPage pesquisaPage = new PesquisaPage();
	
	private GlobalStepsController controller = new GlobalStepsController();
	
	@Override
	public void validarTextoPagina(String textoEsperado, String mensagem) {
		
		LogReport.passFail(controller.getPage(new PesquisaPage()).textoExibidoPagina(textoEsperado), mensagem);
	}
	
	@Override
	public void clicarBotao(String botao) {
		
		controller.getPage(new PesquisaPage()).clicarBotao(botao);
	}
	
	@Override
	public void deslizarParaEsquerda(int qtde) throws Exception {
		
		controller.getPage(new PesquisaPage()).deslizarParaEsquerda(qtde);
	}
	
	@Override
	public void deslizarParaDireita(int qtde) throws Exception {
		
		controller.getPage(new PesquisaPage()).deslizarParaDireia(qtde);
	}
	
	@Override
	public void instalarApp() {
		
		pesquisaPage.setupEnviroment();
	}
	
	@Override
	public void finalizarApp() throws Exception {
		
		pesquisaPage.driverClose();
	}
	
	@Override
	public void desinstalarApp() {
		
		pesquisaPage.uninstallApp();
	}

	@Override
	public void deslizarParaCima(int qtde) {
		
		controller.getPage(new PesquisaPage()).deslizarParaCima(qtde);
	}

	@Override
	public void deslizarParaBaixo(int qtde) {
		
		controller.getPage(new PesquisaPage()).deslizarParaBaixo(qtde);
	}

	@Override
	public void deslizarParaEsquerdaElementoVisivel(String elemento) {
		
		controller.getPage(new PesquisaPage()).deslizarParaEsquerdaElementoVisivel(elemento);
	}

	@Override
	public void deslizarParaDireitaElementoVisivel(String elemento) {
		
		controller.getPage(new PesquisaPage()).deslizarParaEsquerdaElementoVisivel(elemento);
	}

	@Override
	public void deslizarParaDireitaTextoVisivel(String texto) {
		
		controller.getPage(new PesquisaPage()).deslizarParaDireitaTextoVisivel(texto);
	}

	@Override
	public void deslizarParaEsquerdaTextoVisivel(String texto) {
		
		controller.getPage(new PesquisaPage()).deslizarParaEsquerdaTextoVisivel(texto);
	}

	@Override
	public void digitarTexto(String name, String value) {
		
		controller.getPage(new PesquisaPage()).digitarTexto(name, value);
	}

	@Override
	public void selecionarItemListaSuspensa(String name, String value, String message) {
		
		controller.getPage(new PesquisaPage()).selecionarItemListaSuspensa(name, value, message);
	}

	@Override
	public void deslizarParaBaixoTextoVisivel(String texto) {
		
		controller.getPage(new PesquisaPage()).deslizarParaBaixoTextoVisivel(texto);
	}

	@Override
	public Boolean textoExibidoPagina(String texto) {
		
		return controller.getPage(new PesquisaPage()).textoExibidoPagina(texto);
	}
	
	@Override
	public void menu() {
		
		controller.getPage(new PesquisaPage()).clicarBotao("menu");
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
