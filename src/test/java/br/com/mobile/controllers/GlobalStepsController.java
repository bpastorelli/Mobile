package br.com.mobile.controllers;	

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import br.com.mobile.enums.PageEnum;
import br.com.mobile.interfaces.Actions;
import br.com.mobile.interfaces.Page;
import br.com.mobile.reports.LogReport;

public class GlobalStepsController {
	
	private static String page;
	
	private static Map<String, Actions> mapaActions = new HashMap<String, Actions>();
	
	public void addActions(String key, Actions actions) {
		
		mapaActions.put(key, actions);
	}
	
	public Actions getAction() {
		
		return getAction(null);
	}
	
	public Actions getAction(PageEnum pagina) {
		
		Actions actions;
		page = Objects.equals(pagina.get(), null) ? page : pagina.get();
		
		if(!mapaActions.containsKey(page))
			LogReport.fail("A pagina [" + page + "] não foi encontrada no mapa de configurações de páginas.");
			
		actions = mapaActions.get(page);
		
		if(actions instanceof Actions)
			return actions;
		else
			return null;
	}
	
	public Page getPage(Page page) {
		
		if(page instanceof Page)
			return page;
		else
			return null;
	}
	
	public String getCurrentPage() {
		
		return page;
	}
}
