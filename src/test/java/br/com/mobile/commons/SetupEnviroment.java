package br.com.mobile.commons;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import br.com.mobile.utils.Command;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class SetupEnviroment {
	
	protected static WebDriver driver;
	
	private DesiredCapabilities caps;
	
	private AppiumDriverLocalService service;
	
	private static final String process = "Appium.exe";
	
	public WebDriver setupEnviroment() throws URISyntaxException {
		
		caps = new DesiredCapabilities();
		caps.setCapability("noReset", Property.APP_NORESET);
		caps.setCapability("fullReset", Property.APP_FULLRESET);
		caps.setCapability("deviceName", Property.DEVICE_NAME);
		caps.setCapability("platformName", Property.PLATFORM_NAME);
		caps.setCapability("platformVersion", Property.PLATFORM_VERSION);
		caps.setCapability("appPackage", Property.APP_PACKAGE);
		caps.setCapability("appActivity", Property.APP_ACTIVITY);				
		service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingAnyFreePort());
		
		try {	
			
			driver = new AndroidDriver<MobileElement>(new URL("http:" 
					+ Property.APPIUM_IP 
					+ ":" + Property.APPIUM_PORT + "/wd/hub"), caps);
		} catch (MalformedURLException e) {
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
