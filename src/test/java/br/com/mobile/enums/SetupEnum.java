package br.com.mobile.enums;

import br.com.mobile.implementations.SetupAndroid;
import br.com.mobile.implementations.SetupAndroidAppCenter;
import br.com.mobile.interfaces.SetupEnviroment;

public enum SetupEnum {

	ANDROID(new SetupAndroid()),
	APP_CENTER(new SetupAndroidAppCenter());
	
    private SetupEnviroment setup;
	 
    SetupEnum(SetupEnviroment setup) {
        this.setup = setup;
    }
 
    public SetupEnviroment get() {
        return setup;
    }

}
