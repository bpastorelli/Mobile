package br.com.mobile.enums;

import br.com.mobile.implementations.SetupAndroid;
import br.com.mobile.implementations.SetupAndroidAppCenter;
import br.com.mobile.interfaces.SetupEnviroment;

public enum PlataformaEnum {

	MOBILE(new SetupAndroid()),
	APPCENTER(new SetupAndroidAppCenter());
	
    private SetupEnviroment setup;
	 
    PlataformaEnum(SetupEnviroment setup) {
        this.setup = setup;
    }
 
    public SetupEnviroment get() {
        return setup;
    }
        
}
