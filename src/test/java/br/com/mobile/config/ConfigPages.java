package br.com.mobile.config;

import br.com.mobile.actions.ActionsBoasVindas;
import br.com.mobile.actions.ActionsConfiguration;
import br.com.mobile.controllers.GlobalStepsController;

public class ConfigPages {
	
	private static GlobalStepsController controller = new GlobalStepsController();
	
	private static void setPages() {
		
		controller.addActions("boas vindas", new ActionsBoasVindas());
		controller.addActions("configuracao", new ActionsConfiguration());
	}
	
	public static void loadPages() {
		
		setPages();
	}

}
