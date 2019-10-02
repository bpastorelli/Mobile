package br.com.mobile.interfaces;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public interface SetupEnviroment {
	
	AppiumDriver<MobileElement> setupEnviroment();
	
	AppiumDriver<MobileElement> getDriver();
	
	void driverClose();
	
	void serviceStop() throws Exception;

}
