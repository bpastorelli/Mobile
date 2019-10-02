package br.com.mobile.commons;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import br.com.mobile.utils.Command;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class SetupEnviroment {
	
	protected static AppiumDriver<MobileElement> driver;
	
	private DesiredCapabilities caps; 
	
	private AppiumServiceBuilder builder;
	
	private AppiumDriverLocalService service;
	
	private static final String process = "Appium.exe";
	
	public WebDriver setupEnviroment() throws Exception {
		
		caps = new DesiredCapabilities();
		caps.setCapability("noReset", Property.APP_NORESET);
		caps.setCapability("fullReset", Property.APP_FULLRESET);
		caps.setCapability("deviceName", Property.DEVICE_NAME);
		caps.setCapability("platformName", Property.PLATFORM_NAME);
		caps.setCapability("platformVersion", Property.PLATFORM_VERSION);
		caps.setCapability("appPackage", Property.APP_PACKAGE);
		caps.setCapability("appActivity", Property.APP_ACTIVITY);
		
		builder = new AppiumServiceBuilder();
		builder.withIPAddress(Property.APPIUM_IP);
		builder.usingPort(Property.APPIUM_PORT);
		builder.withCapabilities(caps);
		builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
		builder.withArgument(GeneralServerFlag.LOG_LEVEL,"error");

		service = AppiumDriverLocalService.buildService(builder);
		service.start();
		
		try {	
			
			driver = new AppiumDriver<MobileElement>(new URL("http:" 
					+ Property.APPIUM_IP 
					+ ":" + Property.APPIUM_PORT + "/wd/hub"), caps);
		} catch (Exception e) {
			System.out.println("Falha ao abrir o app:" + e.getMessage());
		}
		
		return driver;
	}
	
	public WebDriver getDriver() {
		
		return driver;
	}
	
	public void driverClose() {
		
		try {
			driver.quit();
		}catch(Exception e) {
			System.out.println("[FALHA]Falha ao fechar o driver [" + e.getMessage() + "]");
		}
	}	
	
	public void serviceStop() throws Exception {
		
		if(Command.isProcessRunning(process))
			Command.killProcess(process);
		
		if(service.isRunning())
			service.stop();
	}	
}
