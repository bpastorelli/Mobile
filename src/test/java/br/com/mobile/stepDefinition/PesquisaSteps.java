package br.com.mobile.stepDefinition;

import br.com.mobile.controllers.GlobalStepsController;
import br.com.mobile.enums.PageEnum;
import cucumber.api.java.en.And;

public class PesquisaSteps {
	
	private GlobalStepsController controller = new GlobalStepsController();
	
	@And("^Escolho o produto \"([^\"]*)\" na lista de \"([^\"]*)\"$")
	public void seleciono_item_lista_suspensa(String item, String name) {
		
		controller.getAction(PageEnum.PESQUISA).selecionarItemListaSuspensa(name, item, "Escolher o produto " + item);
	}
	
}
	