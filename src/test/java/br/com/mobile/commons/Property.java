package br.com.mobile.commons;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public abstract class Property {
	
	public static Integer TIMEOUT;
	
	public static String DEVICE_NAME;
	
	public static String PLATFORM_NAME;
	
	public static String PLATFORM_VERSION;
	
	public static String APP_PACKAGE;
	
	public static String APP_ACTIVITY;
	
	public static String APP_PATH;
	
	public static Boolean APK_INSTALL;
	
	public static String APPIUM_IP;
	
	public static Integer APPIUM_PORT;
	
	public static Boolean APP_NORESET;
	
	public static Boolean APP_FULLRESET;
	
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
			TIMEOUT                    = Integer.parseInt(properties.getProperty("selenium.element.timeout"));
			DEVICE_NAME                = properties.getProperty("app.device.name").trim();
			PLATFORM_NAME              = properties.getProperty("app.apk.platformName").trim();
			PLATFORM_VERSION           = properties.getProperty("app.apk.platformVersion").trim();
			APP_PACKAGE                = properties.getProperty("app.apk.appPackage").trim();
			APP_ACTIVITY               = properties.getProperty("app.apk.appActivity").trim();
			APP_PATH                   = properties.getProperty("app.apk.path").trim();
			APK_INSTALL                = Boolean.parseBoolean(properties.getProperty("app.apk.install"));
			APPIUM_IP                  = properties.getProperty("app.appium.ip").trim();
			APPIUM_PORT                = Integer.parseInt(properties.getProperty("app.appium.port"));
			APP_NORESET                = Boolean.parseBoolean(properties.getProperty("app.apk.noReset"));
			APP_FULLRESET              = Boolean.parseBoolean(properties.getProperty("app.apk.fullReset"));
			HTML_REPORTER_PATH         = properties.getProperty("extent.report.path").trim();
			HTML_REPORTER_NAME         = properties.getProperty("extent.report.name").trim();
			HTML_REPORTER_TITLE        = properties.getProperty("extent.report.title").trim();
			HTML_REPORTER_PAGE_NAME    = properties.getProperty("extent.report.page.name").trim();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
