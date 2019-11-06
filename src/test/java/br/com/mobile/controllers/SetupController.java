package br.com.mobile.controllers;	

import br.com.mobile.commons.Property;
import br.com.mobile.entities.EntitySetup;
import br.com.mobile.implementations.BasePageAndroid;
import br.com.mobile.implementations.BasePageAppCenter;
import br.com.mobile.implementations.SetupAndroid;
import br.com.mobile.implementations.SetupAndroidAppCenter;
import br.com.mobile.interfaces.SetupEnviroment;

public class SetupController {
	
	public SetupEnviroment setup;
	
	public static SetupEnviroment loadSetup() {
		
		EntitySetup e = new EntitySetup();
		
		switch(Property.PLATAFORMA_CI) {
			case "appcenter":
				e.setBasePage(new BasePageAppCenter());
				e.setSetup(new SetupAndroidAppCenter());
				e.getSetup().setupEnviroment();
				break;
			case "mobile":
				e.setBasePage(new BasePageAndroid());
				e.setSetup(new SetupAndroid());
				e.getSetup().setupEnviroment();
				break;
		}
		return e.getSetup();
	}
	
}
