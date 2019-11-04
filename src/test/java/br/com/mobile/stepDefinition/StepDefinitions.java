package br.com.mobile.stepDefinition;

import br.com.mobile.actions.android.ActionsMobile;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class StepDefinitions {
 
	private ActionsMobile actionsMobile = new ActionsMobile();
	
	@And("^Que efetuo o login com usuario e senha validos$")
	public void que_efetue_login_com_usuario_senha_validos() {
		
		actionsMobile.logar("brunopastorelli@hotmail.com", "sid04197");
	}
	
	@Then("^Pesquiso o produto tipo \"([^\"]*)\" descricao \"([^\"]*)\"$")
	public void pesquiso_produto_descricao_e_preco(String produto, String descricao) throws InterruptedException {
		
		actionsMobile.retornarInicio();
		actionsMobile.pesquisaProduto(produto, descricao);
	}
	
	@And("^Adiciono o produto ao meu carrinho$")
	public void adiciono_produto_carrinho() {
		
		actionsMobile.adicionarProdutoCarrinho();
	}
	
	@And("^Removo todos os produtos do carrinho$")
	public void removier_produtos_carrinho() {
		
		actionsMobile.retornarInicio();
		actionsMobile.removerProdutosCarrinho("O seu carrinho está vazio");
	}
	
	@And("^Visualizo o preco de \"([^\"]*)\" do produto$")
	public void visualizo_preco_produto(String preco) {
		
		actionsMobile.validarTexto(preco);
	}

} 
