package br.com.mobile.config;

import br.com.mobile.actions.ActionsContinuar;
import br.com.mobile.actions.ActionsInicial;
import br.com.mobile.actions.ActionsLogar;
import br.com.mobile.actions.ActionsPesquisa;
import br.com.mobile.controllers.GlobalStepsController;
import br.com.mobile.enums.Page;

public class ConfigPages {
	
	private static GlobalStepsController controller = new GlobalStepsController();
	
	private static void setPages() {
		
		controller.addActions(null, new ActionsInicial());
		controller.addActions(Page.INICIAL.get(), new ActionsInicial());
		controller.addActions(Page.CONTINUAR.get(), new ActionsContinuar());
		controller.addActions(Page.LOGAR.get(), new ActionsLogar());
		controller.addActions(Page.PESQUISA.get(), new ActionsPesquisa());
	}
	
	public static void loadPages() {
		
		setPages();
	}

}
