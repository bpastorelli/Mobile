package br.com.mobile.config;

import br.com.mobile.controllers.SetupController;
import br.com.mobile.enums.SetupEnum;
import br.com.mobile.implementations.SetupAndroid;
import br.com.mobile.implementations.SetupAndroidAppCenter;

public class ConfigSetup {
	
	private static SetupController controller = new SetupController();
	
	private static void setSetups() {
		
		controller.add(SetupEnum.APP_CENTER, new SetupAndroidAppCenter());
		controller.add(SetupEnum.ANDROID, new SetupAndroid());
	}
	
	public static void loadSetups() {
		
		setSetups();
	}

}
