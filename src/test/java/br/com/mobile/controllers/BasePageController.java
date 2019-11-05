package br.com.mobile.controllers;	

import br.com.mobile.commons.Property;
import br.com.mobile.implementations.BasePageAndroid;
import br.com.mobile.implementations.BasePageAppCenter;
import br.com.mobile.interfaces.BasePage;

public class BasePageController {
	
	public static BasePage getBasePage() {
		
		BasePage base = null;
		
		switch(Property.PLATAFORMA_CI) {
			case "appcenter":
				base = new BasePageAppCenter();
				break;
			case "mobile":
				base = new BasePageAndroid();
				break;
		}
		return base;

	}
}
