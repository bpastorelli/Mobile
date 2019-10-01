package br.com.mobile.commons;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class SetupEnviroment {
	
	protected static WebDriver driver;
	
	private AppiumDriverLocalService service;
	
	private AppiumServiceBuilder     builder;
	
	private DesiredCapabilities      caps;
	
	public WebDriver setupEnviroment() throws URISyntaxException {
		
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
		builder.usingPort(Integer.parseInt(Property.APPIUM_PORT));
		builder.withCapabilities(caps);
		builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
		builder.withArgument(GeneralServerFlag.LOG_LEVEL,"error");

		service = AppiumDriverLocalService.buildService(builder);
		service.start();
		
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
			driver.close();
		}catch(Exception e) {
			try {
				Runtime.getRuntime().exec("TASKKILL /F /IM calculator.exe");
			} catch (IOException e1) {
				System.out.println("[FALHA]Falha ao fechar o driver [" + e.getMessage() + "]");
			}
		}
	}	
	
	public void serviceStop() {
		
		service.stop();
	}	
}
