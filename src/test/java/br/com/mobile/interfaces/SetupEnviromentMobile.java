package br.com.mobile.interfaces;

import com.microsoft.appcenter.appium.EnhancedAndroidDriver;

import io.appium.java_client.MobileElement;

public interface SetupEnviromentMobile {
	
	/**
	 * Starta o serviço do Appium e o app
	 * 
	 * @return AppiumDriver<MobileElement>
	 */
	EnhancedAndroidDriver<MobileElement> setupEnviroment();
	
	/**
	 * Retorna o driver
	 * 
	 * @return AppiumDriver<MobileElement>
	 */
	EnhancedAndroidDriver<MobileElement> getDriver();
	
	/**
	 * Fecha o driver (App)
	 */
	void driverClose();
	
	/**
	 * Pára o serviço do Appium
	 * 
	 * @throws Exception
	 */
	void serviceStop() throws Exception;
	
	/**
	 * Desinstala a APk
	 */
	void uninstallApp();

}
