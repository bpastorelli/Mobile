package br.com.mobile.stepDefinition;

import br.com.mobile.actions.android.ActionsMobile;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions {
	
	private ActionsMobile actionsMobile = new ActionsMobile();
	
	@And("^Que efetuo o login com usuario \"([^\"]*)\" e senha \"([^\"]*)\" validos$")
	public void que_efetue_login_com_usuario_senha_validos(String usuario, String senha) {
		
		actionsMobile.logar(usuario, senha);
	}
	
	@Then("^Pesquiso o produto tipo \"([^\"]*)\" descricao \"([^\"]*)\"$")
	public void pesquiso_produto_descricao_e_preco(String produto, String descricao) throws InterruptedException {
		
		actionsMobile.retornarInicio("Pagar com QR");
		actionsMobile.pesquisaProduto(produto, descricao);
	}
	
	@And("^Adiciono o produto ao meu carrinho$")
	public void adiciono_produto_carrinho() {
		
		actionsMobile.adicionarProdutoCarrinho();
	}
	
	@And("^Removo todos os produtos do carrinho$")
	public void removier_produtos_carrinho() {
		
		actionsMobile.retornarInicio("Pagar com QR");
		actionsMobile.removerProdutosCarrinho("O seu carrinho está vazio");
	}
	
	@And("^Visualizo o preco de \"([^\"]*)\" do produto$")
	public void visualizo_preco_produto(String preco) {
		
		actionsMobile.validarTexto(preco);
	}
	
	@And("^Efetuo o logout do aplicativo$") 
	public void efetuo_logout_aplicativo() {
		
		actionsMobile.retornarInicio("Pagar com QR");
		actionsMobile.logout();
	}
	
	@And("^Que eu quero pesquisar um veiculo tipo \"([^\"]*)\"$")
	public void clico_no_menu(String tipo) {
		
		actionsMobile.retornarInicio("Pagar com QR");
		actionsMobile.irParaMenuVeiculos(tipo);
	}
	
	@And("^Seleciono a marca \"([^\"]*)\" e modelo \"([^\"]*)\"$")
	public void selecio_marca_e_modelo(String marca, String modelo) {
		
		actionsMobile.selecionarMarcaModelo(marca, modelo);
	}
	
	@When("^Escolho o veiculo \"([^\"]*)\" e visualizo$")
	public void escolho_o_veiculo_e_visualizo(String descricao) {
		
		actionsMobile.escolherProduto(descricao);
	}
	
	@When("^Marco o produto nos meus favoritos$")
	public void marcar_produto_como_favorito() {
		
		actionsMobile.favoritarProduto();
	}
	
	@Then("^Valido se o produto \"([^\"]*)\" esta presenta na lista de favoritos$")
	public void valido_se_o_produto_esta_presente_na_lista_de_favoritos(String descricao) {
		
		actionsMobile.validarProdutoListaFavoritos(descricao);
	}
	
	@When("^Removo todos os produtos da lista de favoritos$")
	public void removo_produtos_lista_favoritos() {
		
		actionsMobile.retornarInicio("Pagar com QR");
		actionsMobile.irParaMenuFavoritos();
		actionsMobile.removerProdutosListaFavoritos();
	}
	
} 
