package br.com.mobile.controllers;

import br.com.mobile.actions.ActionsBoasVindas;
import br.com.mobile.actions.ActionsConfiguration;
import br.com.mobile.interfaces.Actions;

public class GlobalStepsController {
	
	public Actions getAction(String pagina) {
		
		Actions actions;
		
		switch(pagina) {
		case "boas vindas":
			actions = new ActionsBoasVindas();
			break;
		case "configuracao":
			actions = new ActionsConfiguration();
			break;
		default:
			actions = null;
		}
		
		return actions;
		
	}

}
