package br.com.mobile.controllers;

import java.util.HashMap;
import java.util.Map;

import br.com.mobile.interfaces.Actions;
import br.com.mobile.reports.LogReport;

public class GlobalStepsController {
	
	Map<String, Actions> mapaActions = new HashMap<String, Actions>();
	
	public void addActions(String key, Actions actions) {
		
		this.mapaActions.put(key, actions);
	}
	
	public Actions getAction(String pagina) {
		
		Actions actions;
		
		if(!this.mapaActions.containsKey(pagina))
			LogReport.fail("A pagina " + pagina + " não foi encontrada no mapa de configuração de páginas.");
			
		actions = this.mapaActions.get(pagina);
		
		if(actions instanceof Actions)
			return actions;
		else
			return null;
	}
}
