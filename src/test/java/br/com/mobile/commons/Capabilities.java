package br.com.mobile.commons;

import org.openqa.selenium.remote.DesiredCapabilities;

import br.com.mobile.utils.Utils;

public class Capabilities {
	
	private DesiredCapabilities caps;
	
	public DesiredCapabilities getCapabilities() {
		
		Utils.log("[APPIUM]Iniciando o serviço do Appium...");
		
		caps = new DesiredCapabilities();
		caps.setCapability("automationName", Property.APPIUM_AUTOMATION_NAME);
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
		
		return caps;
	}

}
