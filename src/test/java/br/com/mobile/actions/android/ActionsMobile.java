package br.com.mobile.actions.android;

import java.util.List;

import br.com.mobile.commons.Property;
import br.com.mobile.controllers.PagesController;
import br.com.mobile.pages.CarrinhoPage;
import br.com.mobile.pages.ContinuarPage;
import br.com.mobile.pages.FavoritosPage;
import br.com.mobile.pages.InicialPage;
import br.com.mobile.pages.LogarPage;
import br.com.mobile.pages.MenuPage;
import br.com.mobile.pages.MinhaContaPage;
import br.com.mobile.pages.PesquisaPage;
import br.com.mobile.reports.LogReport;
import io.appium.java_client.MobileElement;

public class ActionsMobile extends PagesController {
	
	private static String produto;
	
	private MenuPage menuPage = new MenuPage();
	
	private LogarPage logarPage = new LogarPage();
	
	private InicialPage inicialPage = new InicialPage();
	
	private ContinuarPage continuarPage = new ContinuarPage();
	
	private PesquisaPage pesquisaPage = new PesquisaPage();
	
	private CarrinhoPage carrinhoPage = new CarrinhoPage();
	
	private MinhaContaPage minhaContaPage =  new MinhaContaPage();
	
	private FavoritosPage favoritosPage = new FavoritosPage();
	
	public void logar(String usuario, String senha) {
		
		getPage(this.inicialPage).ifPopupIsPresent("Instale a nova versão disponível", "MAIS TARDE", 2);
		getPage(this.inicialPage).ifPopupIsPresent("Acessar a minha conta", "Acessar a minha conta", 2);
		if(getPage(this.inicialPage).textoExibidoPagina("Onde você está?", 2))		
			getPage(this.inicialPage).selecionarItemListaSuspensa("paises", "Brasil", "Clicar no país de localização");
		
		getPage(this.inicialPage).ifPopupIsPresent("Instale a nova versão disponível", "MAIS TARDE", 2);
		getPage(this.inicialPage).ifPopupIsPresent("O que está esperando?", "Já tenho conta");
		getPage(this.continuarPage).ifPopupIsPresent("Continuar com", "NENHUMA DAS ALTERNATIVAS ACIMA");			
		
		if(getPage(this.logarPage).textoExibidoPagina("E-mail ou usuário")) {
			getPage(this.logarPage).digitarTexto("e-mail", usuario);
			getPage(this.logarPage).clicarBotao("Continuar");
		}
		
		getPage(this.logarPage).textoExibidoPagina("Senha");
		getPage(this.logarPage).digitarTexto("senha", senha);
		getPage(this.logarPage).clicarBotao("Entrar");
		getPage(this.inicialPage).ifPopupIsPresent("Salvar senha do Mercado Livre", "NUNCA", 2);
		getPage(this.inicialPage).ifPopupIsPresent("Instale a nova versão disponível", "MAIS TARDE", 2);
	}
	
	public void pesquisaProduto(String produto, String descricao) {
		
		getPage(this.pesquisaPage).clicarBotao("Buscar");
		getPage(this.pesquisaPage).digitarTexto("txtBusca", produto);
		getPage(this.pesquisaPage).selecionarItemListaSuspensa("produtos", produto, "Selecionar item " + produto);
		getPage(this.pesquisaPage).selecionarItemListaSuspensa("produtos", descricao, "Selecionar item " + descricao);
	}
	
	public void novaPesquisaProduto(String produto, String descricao, String esperado) {
		
		getPage(this.pesquisaPage).clicarBotao("nova pesquisa");
		getPage(this.pesquisaPage).digitarTexto("txtBusca", produto);
		getPage(this.pesquisaPage).selecionarItemListaSuspensa("produtos", produto, "Selecionar item " + produto);
		getPage(this.pesquisaPage).selecionarItemListaSuspensa("produtos", descricao, "Selecionar item " + descricao);
	}

	public void adicionarProdutoCarrinho() {
		
		getPage(this.pesquisaPage).deslizarParaBaixoElementoVisivel("adicionarCarrinho");
		getPage(this.pesquisaPage).clicarBotao("adicionarCarrinho");
	}
	
	public void removerProdutosCarrinho(String mensagem) {
		
		//Executa exclusão dos produtos até apareça a mensagem esperada.
		getPage(this.pesquisaPage).clicarBotao("carrinho");
		
		do{	
			getPage(this.carrinhoPage).clicarBotao("menuCarrinho");
			getPage(this.carrinhoPage).selecionarItemListaSuspensa("opcoesCarrinho", "Excluir produto", "");
			
			LogReport.passFail(getPage(this.carrinhoPage).textoExibidoPagina("Você excluiu um produto.", 5), "Exclusão de produto");
		}while(!getPage(this.carrinhoPage).textoExibidoPagina(mensagem, 5));
	}
	
	public void logout() {
		
		getPage(this.inicialPage).clicarBotao("menu");
		getPage(this.menuPage).clicarBotao("Minha conta");
		getPage(this.minhaContaPage).clicarBotao("sair");
		getPage(this.minhaContaPage).ifPopupIsPresent("Deseja sair da sua conta?", "SIM, SAIR");
	}
	
	public void retornarInicio(String texto) {
		
		getPage(this.inicialPage).voltar(texto);
	}
	
	public void validarTexto(String texto) {
		
		LogReport.passFail(getPage(this.inicialPage).textoExibidoPagina(texto), "Texto esperado: " + texto);
	}
	
	public Boolean textoEncontrado(String texto) {
		
		return textoEncontrado(texto, Property.TIMEOUT);
	}
	
	public Boolean textoEncontrado(String texto, Integer timeout) {
		
		return getPage(this.inicialPage).textoExibidoPagina(texto, timeout);
	}
	
	public void irParaMenuVeiculos(String tipo) {
		
		getPage(this.inicialPage).clicarBotao("Carros, motos e outros");
		getPage(this.inicialPage).clicarBotao(tipo);
	}
	
	public void irParaMenuFavoritos() {
		
		getPage(this.inicialPage).clicarBotao("menu");
		getPage(this.menuPage).clicarBotao("Favoritos");
		getPage(this.favoritosPage).textoExibidoPagina("Favoritos");
	}
	
	public void selecionarMarcaModelo(String marca, String modelo) {
		
		getPage(this.inicialPage).ifPopupIsPresent("Qual marca e modelo?","marcaModelo");
		getPage(this.inicialPage).textoExibidoPagina("Marca");
		getPage(this.pesquisaPage).selecionarItemListaSuspensa("marcas", marca, "Selecionar item " + marca);
		getPage(this.pesquisaPage).textoExibidoPagina(marca);
		getPage(this.pesquisaPage).selecionarItemListaSuspensa("modelos", modelo, "Selecionar item " + modelo);
		getPage(this.pesquisaPage).clicarBotao("aplicar");
		getPage(this.pesquisaPage).clicarBotao("buscarVeiculo");
	}
	
	public void escolherProduto(String descricao) {
		
		getPage(this.pesquisaPage).textoExibidoPagina("resultados");
		getPage(this.pesquisaPage).selecionarItemListaSuspensa("produtos", descricao, "Selecionar item " + descricao);
		getPage(this.pesquisaPage).ifPopupIsPresent("Agora você pode reservar", "reservarVeiculo", 2);
	}
	
	public void favoritarProduto() {
		
		getPage(this.pesquisaPage).clicarBotao("favoritar");
	}
	
	public void validarProdutoListaFavoritos(String descricao) {
		
		getPage(this.inicialPage).clicarBotao("menu");
		getPage(this.menuPage).clicarBotao("Favoritos");
		getPage(this.favoritosPage).textoExibidoPagina("Favoritos");
		getPage(this.pesquisaPage).selecionarItemListaSuspensa("produtos", descricao, "Selecionar item " + descricao);
		
		LogReport.passFail(getPage(this.inicialPage).textoExibidoPagina(descricao, 10), "Descricao esperada: " + descricao);
	}
	
	public void validarProdutoListaFavoritos() {
		
		getPage(this.inicialPage).clicarBotao("menu");
		getPage(this.menuPage).clicarBotao("Favoritos");
		getPage(this.favoritosPage).textoExibidoPagina("Favoritos");
		getPage(this.pesquisaPage).selecionarItemListaSuspensa("produtos", produto, "Selecionar item " + produto);
		
		LogReport.passFail(getPage(this.inicialPage).textoExibidoPagina(produto, 10), "Descricao esperada: " + produto);
	}
	
	public void escolherProdutoSemVisualizar(String descricao) {
		
		getPage(this.pesquisaPage).deslizarParaBaixoTextoVisivel(descricao);
	}
	
	public void removerProdutosListaFavoritos() {
		
		List<MobileElement> elements = getPage(this.favoritosPage).retornaElementos("favoritos");
		
		for(MobileElement e : elements) {
			getPage(this.favoritosPage).textoExibidoPagina("Favoritos");
			getPage(this.favoritosPage).clicarBotao(e);
			getPage(this.pesquisaPage).ifPopupIsPresent("Agora você pode reservar", "reservarVeiculo", 2);
			getPage(this.pesquisaPage).clicarBotao("favoritar");
			irParaMenuFavoritos();
		}
	}
	
	public void favoritarProdutoNaLista(String ordem) {
		
		Integer numero = 0;
		
		List<MobileElement> elements = getPage(this.favoritosPage).retornaElementos("produtos");
		
		if(elements.size() > 0) {
			
			switch(ordem) {
			case "primeiro":
				numero=1;
				break;
			case "segundo":
				numero=2;
				break;
			case "terceiro":
				numero=3;
				break;
			case "quarto":
				numero=4;
				break;
			}
			
			produto = elements.get(numero).getText();
			getPage(this.pesquisaPage).clicarBotao(String.valueOf(numero));
			
		}else {
			
			LogReport.fail("Não existem veiculos na lista.");
		}

	}
	
}
