package br.com.mobile.implementations;

import java.net.URL;

import com.microsoft.appcenter.appium.EnhancedAndroidDriver;
import com.microsoft.appcenter.appium.Factory;

import br.com.mobile.appium.Appium;
import br.com.mobile.capabilities.Capabilities;
import br.com.mobile.commons.Property;
import br.com.mobile.interfaces.SetupEnviroment;
import br.com.mobile.utils.Command;
import br.com.mobile.utils.Utils;
import io.appium.java_client.MobileElement;

public class SetupAndroidAppCenter implements SetupEnviroment {
	
	protected static EnhancedAndroidDriver<MobileElement> driver;
	
	private static final String process = "Appium.exe";
	
	private Capabilities caps = new Capabilities(); 
	
	@Override
	public void setupEnviroment() {
		
		try {	
			Utils.log("[APLICATIVO]Iniciando o aplicativo...");
			URL url = new URL("http:" 
							+ Property.APPIUM_IP 
							+ ":" + Property.APPIUM_PORT + "/wd/hub");
			driver = Factory.createAndroidDriver(url, caps.getCapabilities());
		} catch (Exception e) {
			
			Utils.log("[FALHA]Falha ao iniciar o aplicativo:" + e.getMessage());
		}
		
		Utils.log("[SUCESSO]Aplicativo iniciado com sucesso.");
	}
	
	@Override
	public EnhancedAndroidDriver<MobileElement> getDriver() {
		
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
		
	}	
}
