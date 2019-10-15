package br.com.mobile.config;

import br.com.mobile.actions.ActionsContinuar;
import br.com.mobile.actions.ActionsInicial;
import br.com.mobile.actions.ActionsLogar;
import br.com.mobile.actions.ActionsPesquisa;
import br.com.mobile.controllers.GlobalStepsController;

public class ConfigPages {
	
	private static GlobalStepsController controller = new GlobalStepsController();
	
	private static void setPages() {
		
		controller.addActions(null, new ActionsInicial());
		controller.addActions("inicial", new ActionsInicial());
		controller.addActions("continuar", new ActionsContinuar());
		controller.addActions("logar", new ActionsLogar());
		controller.addActions("pesquisa", new ActionsPesquisa());
	}
	
	public static void loadPages() {
		
		setPages();
	}

}
