package br.com.mobile.stepDefinition;

import br.com.mobile.actions.android.ActionsMobile;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class StepDefinitions {

	private ActionsMobile actionsMobile = new ActionsMobile();
	
	@And("^Que efetuo o login com usuario e senha$")
	public void que_efetue_login_com_usuario_senha() {
		
		actionsMobile.logar("brunopastorelli@hotmail.com", "sid04197");
	}
	
	@Then("^Pesquiso o produto tipo \"([^\"]*)\" descricao \"([^\"]*)\" com o preco \"([^\"]*)\"$")
	public void pesquiso_produto_descricao_e_preco(String produto, String descricao, String preco) throws InterruptedException {
		
		actionsMobile.pesquisaProduto(produto, descricao, preco);
	}
	
	@And("^Adiciono o produto ao meu carrinho e recebo a mensagem \"([^\"]*)\"$")
	public void adiciono_produto_carrinho(String mensagem) {
		
		actionsMobile.adicionarProdutoCarrinho(mensagem);
	}
	
	@And("^Removo todos os produtos do carrinho e recebo a mensagem \"([^\"]*)\"$")
	public void removier_produtos_carrinho(String mensagem) {
		
		actionsMobile.removerProdutosCarrinho(mensagem);
	}

} 
