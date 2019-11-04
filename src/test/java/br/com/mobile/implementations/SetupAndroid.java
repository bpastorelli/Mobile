package br.com.mobile.implementations;

import java.net.URL;

import br.com.mobile.capabilities.Capabilities;
import br.com.mobile.commons.Property;
import br.com.mobile.interfaces.SetupEnviroment;
import br.com.mobile.utils.Appium;
import br.com.mobile.utils.Command;
import br.com.mobile.utils.Utils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class SetupAndroid implements SetupEnviroment {
	
	protected static AndroidDriver<MobileElement> driver;
	
	private static final String process = "Appium.exe";
	
	private Capabilities caps = new Capabilities(); 
	
	@Override
	public void setupEnviroment() {
		
		try {	
			Utils.log("[APLICATIVO]Iniciando o aplicativo...");
			driver = new AndroidDriver<MobileElement>(new URL("http:" 
					+ Property.APPIUM_IP 
					+ ":" + Property.APPIUM_PORT 
					+ "/wd/hub"), caps.getCapabilities());
		} catch (Exception e) {
			
			Utils.log("[FALHA]Falha ao iniciar o aplicativo:" + e.getMessage());
		}
		
		Utils.log("[SUCESSO]Aplicativo iniciado com sucesso.");
	}
	
	@Override
	public AppiumDriver<MobileElement> getDriver() {
		
		return driver;
	}
	
	@Override
	public void driverClose() {
		
		try {
			getDriver().quit();
		}catch(Exception e) {
			Utils.log("[FALHA]Falha ao fechar o driver [" + e.getMessage() + "]");
		}
	}	
	
	@Override
	public void serviceStop() throws Exception {
		
		if(Command.isProcessRunning(process))
			Command.killProcess(process);
		
		Appium.stopServer();
	}

	@Override
	public void uninstallApp() {
		
		if(Property.APK_INSTALL) {
			try {
				
				Utils.log("[DESINSTALAR APK]Desinstalando a APK do dispositivo.");
				getDriver().removeApp(Property.APP_PACKAGE);
				Utils.log("[SUCESSO]APK desinstalada com sucesso.");
			}catch(Exception e) {
				
				Utils.log("[INFO]APK já desinstalada.");
			}
		}
		
	}	
}