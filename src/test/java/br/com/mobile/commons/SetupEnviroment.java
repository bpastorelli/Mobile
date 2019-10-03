package br.com.mobile.commons;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public interface SetupEnviroment {
	
	/**
	 * Starta o serviço do Appium e o app
	 * 
	 * @return
	 */
	AppiumDriver<MobileElement> setupEnviroment();
	
	/**
	 * Retorna o driver
	 * 
	 * @return AppiumDriver<MobileElement>
	 */
	AppiumDriver<MobileElement> getDriver();
	
	/**
	 * Fecha o driver
	 */
	void driverClose();
	
	/**
	 * Para o serviço do Appium
	 * 
	 * @throws Exception
	 */
	void serviceStop() throws Exception;
	
	/**
	 * Desinstala a APk
	 */
	void uninstallApp();

}