package br.com.mobile.interfaces;

public interface SetupEnviroment {
	
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
	abstract Object getDriver();
	
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
