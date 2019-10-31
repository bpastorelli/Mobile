package br.com.mobile.implementations;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import br.com.mobile.commons.Property;
import br.com.mobile.interfaces.SetupEnviroment;
import br.com.mobile.utils.Command;
import br.com.mobile.utils.Utils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class SetupAndroid implements SetupEnviroment {
	
	protected static AndroidDriver<MobileElement> driver;
	
	private Command cmd = new Command();
	
	private DesiredCapabilities caps; 
	
	private AppiumServiceBuilder builder;
	
	private AppiumDriverLocalService service;
	
	private static final String process = "Appium.exe";
	
	@Override
	public void setupEnviroment() {
		
		cmd.executeCommand("netstat -ano | findstr " + Property.APPIUM_PORT);
		cmd.killProcessPort();
		cmd.executeCommand("npm install -g maven", false);
		
		Utils.log("[APPIUM]Iniciando o serviço do Appium...");
		caps = new DesiredCapabilities();
		caps.setCapability("noReset", Property.APP_NORESET);
		caps.setCapability("fullReset", Property.APP_FULLRESET);
		caps.setCapability("deviceName", Property.DEVICE_NAME);
		caps.setCapability("platformName", Property.PLATFORM_NAME);
		caps.setCapability("platformVersion", Property.PLATFORM_VERSION);
		caps.setCapability("appPackage", Property.APP_PACKAGE);
		caps.setCapability("appActivity", Property.APP_ACTIVITY);
		caps.setCapability("autoGrantPermissions", Property.AUTO_PERMISSIONS);
		caps.setCapability("autoAcceptAlerts", false);
		caps.setCapability("autoDismissAlerts", true);
		caps.setCapability("app", Utils.getFilePath(Property.APP_PATH).toString());
		
		builder = new AppiumServiceBuilder();
		builder.withIPAddress(Property.APPIUM_IP);
		builder.usingPort(Property.APPIUM_PORT);
		builder.withCapabilities(caps);
		builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
		builder.withArgument(GeneralServerFlag.LOG_LEVEL,"error");
	
		service = AppiumDriverLocalService.buildService(builder);
		service.start();
		
		Utils.log("[SUCESSO]Appium iniciado.");
		
		try {	
			Utils.log("[APLICATIVO]Iniciando o aplicativo...");
			driver = new AndroidDriver<MobileElement>(new URL("http:" 
					+ Property.APPIUM_IP 
					+ ":" + Property.APPIUM_PORT 
					+ "/wd/hub"), caps);
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
		
		if(service.isRunning())
			service.stop();
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