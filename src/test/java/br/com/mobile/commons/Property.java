package br.com.mobile.commons;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public abstract class Property {
	
	public static String DEVICE_NAME;
	
	public static String PLATFORM_NAME;
	
	public static String PLATFORM_VERSION;
	
	public static String APP_PACKAGE;
	
	public static String APP_ACTIVITY;
	
	public static String APP_PATH;
	
	public static String APPIUM_IP;
	
	public static String APPIUM_PORT;
	
	public static String APP_NORESET;
	
	public static String APP_FULLRESET;
	
	public static String HTML_REPORTER_PATH;
	
	public static String HTML_REPORTER_NAME;
	
	public static String HTML_REPORTER_TITLE;
	
	public static String HTML_REPORTER_PAGE_NAME;
	
	private static final String PROP_FILE_CONFIG = "src/test/resources/config.properties";
	
	private static Properties getProp() throws IOException {
		
		Properties props = new Properties();
		FileInputStream file = new FileInputStream(PROP_FILE_CONFIG);
		props.load(file);
		return props;
	}
	
	public static void loadProperties(){
		
		try {
			Properties properties = getProp();
			DEVICE_NAME                = properties.getProperty("app.device.name");
			PLATFORM_NAME              = properties.getProperty("app.apk.platformName");
			PLATFORM_VERSION           = properties.getProperty("app.apk.version");
			APP_PACKAGE                = properties.getProperty("app.apk.appPackage");
			APP_ACTIVITY               = properties.getProperty("app.apk.appActivity");
			APP_PATH                   = properties.getProperty("app.apk.path");
			APPIUM_IP                  = properties.getProperty("app.appium.ip");
			APPIUM_PORT                = properties.getProperty("app.appium.port");
			APP_NORESET                = properties.getProperty("app.apk.noReset");
			APP_FULLRESET              = properties.getProperty("app.apk.fullReset");
			HTML_REPORTER_PATH         = properties.getProperty("");
			HTML_REPORTER_NAME         = properties.getProperty("");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
