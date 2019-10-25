package br.com.mobile.stepDefinition;

import br.com.mobile.actions.android.ActionsMobile;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class StepDefinitions {

	private ActionsMobile actionsMobile = new ActionsMobile();
	
	@And("^Que efetue o login com usuario e senha$")
	public void que_efetue_login_com_usuario_senha() {
		
		actionsMobile.logar("brunopastorelli@hotmail.com", "sid04197");
	}
	
	@Then("^Pesquiso o produto tipo \"([^\"]*)\" descricao \"([^\"]*)\" com o preco \"([^\"]*)\"$")
	public void pesquiso_produto_descricao_e_preco(String produto, String descricao, String preco) {
		
		actionsMobile.pesquisaProduto(produto, descricao, preco);
	}
	

}
