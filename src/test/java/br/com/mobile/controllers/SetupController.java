package br.com.mobile.controllers;	

import java.util.HashMap;
import java.util.Map;

import br.com.mobile.commons.Property;
import br.com.mobile.enums.SetupEnum;
import br.com.mobile.implementations.SetupAndroid;
import br.com.mobile.implementations.SetupAndroidAppCenter;
import br.com.mobile.interfaces.SetupEnviroment;

public class SetupController {
	
	private SetupEnviroment setup;
	
	private static Map<SetupEnum, SetupEnviroment> mapaSetup = new HashMap<SetupEnum, SetupEnviroment>();
	
	public void add(SetupEnum key, SetupEnviroment setup) {
		
		mapaSetup.put(key, setup);
	}
		
	public SetupEnviroment getSetup(SetupEnum setup) {
		
		this.setup = setup.get();
		
		if(this.setup instanceof SetupEnviroment)
			return this.setup;
		else
			return null;
	}
	
	public SetupEnviroment getSetup(SetupEnviroment setup) {
		
		if(setup instanceof SetupEnviroment)
			return setup;
		else
			return null;
	}
	
	public static SetupEnviroment getSetup() {
		
		SetupEnviroment setup = null;
		
		switch(Property.PLATAFORMA_CI) {
			case "appcenter":
				setup = new SetupAndroidAppCenter();
				break;
			case "mobile":
				setup = new SetupAndroid();
				break;
		}
		return setup;
	}
	
	public SetupEnviroment getCurrentSetup() {
		
		return setup;
	}
}
