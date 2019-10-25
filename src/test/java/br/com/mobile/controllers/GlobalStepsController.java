package br.com.mobile.controllers;	

import br.com.mobile.interfaces.Page;

public class GlobalStepsController {
	
	private static String page;
	
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
