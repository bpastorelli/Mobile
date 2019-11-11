package br.com.mobile.actions.android;

import br.com.mobile.commons.Property;
import br.com.mobile.controllers.PagesController;
import br.com.mobile.pages.CarrinhoPage;
import br.com.mobile.pages.ContinuarPage;
import br.com.mobile.pages.InicialPage;
import br.com.mobile.pages.LogarPage;
import br.com.mobile.pages.MenuPage;
import br.com.mobile.pages.MinhaContaPage;
import br.com.mobile.pages.PesquisaPage;
import br.com.mobile.reports.LogReport;

public class ActionsMobile extends PagesController {
	
	private MenuPage menuPage = new MenuPage();
	
	private LogarPage logarPage = new LogarPage();
	
	private InicialPage inicialPage = new InicialPage();
	
	private ContinuarPage continuarPage = new ContinuarPage();
	
	private PesquisaPage pesquisaPage = new PesquisaPage();
	
	private CarrinhoPage carrinhoPage = new CarrinhoPage();
	
	private MinhaContaPage minhaContaPage =  new MinhaContaPage();
	
	public void logar(String usuario, String senha) {
		
		getPage(this.inicialPage).ifPopupIsPresent("Acessar a minha conta", "Acessar a minha conta", 2);
		getPage(this.inicialPage).ifPopupIsPresent("Instale a nova versão disponível", "MAIS TARDE", 2);
		if(getPage(this.inicialPage).textoExibidoPagina("Onde você está?", 2))		
			getPage(this.inicialPage).selecionarItemListaSuspensa("paises", "Brasil", "Clicar no país de localização");
		
		getPage(this.inicialPage).ifPopupIsPresent("Instale a nova versão disponível", "MAIS TARDE", 2);
		getPage(this.inicialPage).ifPopupIsPresent("O que está esperando?", "Já tenho conta", 2);
		getPage(this.continuarPage).ifPopupIsPresent("Continuar com", "NENHUMA DAS ALTERNATIVAS ACIMA", 2);			
		
		if(getPage(this.logarPage).textoExibidoPagina("E-mail ou usuário", 2)) {
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
		getPage(this.pesquisaPage).selecionarItemListaSuspensa("produtos", produto, "");
		getPage(this.pesquisaPage).deslizarParaBaixoTextoVisivel(descricao);
		getPage(this.pesquisaPage).selecionarItemListaSuspensa("produtos filtrados", descricao, "");
	}
	
	public void novaPesquisaProduto(String produto, String descricao, String esperado) {
		
		getPage(this.pesquisaPage).clicarBotao("nova pesquisa");
		getPage(this.pesquisaPage).digitarTexto("txtBusca", produto);
		getPage(this.pesquisaPage).selecionarItemListaSuspensa("produtos", produto, "");
		getPage(this.pesquisaPage).deslizarParaBaixoTextoVisivel(descricao);
		getPage(this.pesquisaPage).selecionarItemListaSuspensa("produtos filtrados", descricao, "");
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
	 
	public void selecionarMarcaModelo(String marca, String modelo) {
		
		getPage(this.inicialPage).ifPopupIsPresent("Qual marca e modelo?","marcaModelo");
		getPage(this.inicialPage).textoExibidoPagina("Marca");
		getPage(this.pesquisaPage).selecionarItemListaSuspensa("marcas", marca, "");
		getPage(this.inicialPage).textoExibidoPagina(marca);
		getPage(this.pesquisaPage).selecionarItemListaSuspensa("modelos", modelo, "");
		getPage(this.pesquisaPage).clicarBotao("aplicar");
		getPage(this.pesquisaPage).clicarBotao("buscarVeiculo");
	}
	
	public void escolherProduto(String descricao) {
		
		getPage(this.pesquisaPage).selecionarItemListaSuspensa("produtos filtrados", descricao, "");
		getPage(this.pesquisaPage).ifPopupIsPresent("Agora você pode reservar", "reservarVeiculo", 2);
	}

}
