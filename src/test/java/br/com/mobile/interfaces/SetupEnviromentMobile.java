package br.com.mobile.interfaces;

import com.microsoft.appcenter.appium.EnhancedAndroidDriver;

import io.appium.java_client.MobileElement;

public interface SetupEnviromentMobile {
	
	/**
	 * Starta o serviço do Appium e o app
	 * 
	 * @return AppiumDriver<MobileElement>
	 */
	abstract void setupEnviroment();
	
	/**
	 * Retorna o driver
	 * 
	 * @return AppiumDriver<MobileElement>
	 */
	abstract EnhancedAndroidDriver<MobileElement> getDriver();
	
	/**
	 * Fecha o driver (App)
	 */
	abstract void driverClose();
	
	/**
	 * Pára o serviço do Appium
	 * 
	 * @throws Exception
	 */
	abstract void serviceStop() throws Exception;
	
	/**
	 * Desinstala a APk
	 */
	abstract void uninstallApp();

}
