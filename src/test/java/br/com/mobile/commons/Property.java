package br.com.mobile.commons;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import br.com.mobile.utils.Utils;

public abstract class Property {
	
	public static Integer TIMEOUT;
	
	public static String DEVICE_NAME;
	
	public static String PLATFORM_NAME;
	
	public static String PLATFORM_VERSION;
	
	public static String APP_PACKAGE;
	
	public static String APP_ACTIVITY;
	
	public static String APP_PATH;
	
	public static String APP_ROOT;
	
	public static Boolean APK_INSTALL;
	
	public static String APPIUM_IP;
	
	public static Integer APPIUM_PORT;
	
	public static String NODEJS;
	
	public static String APPIUMJS;
	
	public static String APPIUM_AUTOMATION_NAME;
	
	public static Boolean APP_NORESET;
	
	public static Boolean APP_FULLRESET;
	
	public static String HTML_REPORTER_PATH;
	
	public static String HTML_REPORTER_NAME;
	
	public static String HTML_REPORTER_TITLE;
	
	public static String HTML_REPORTER_PAGE_NAME;
	
	public static Boolean AUTO_PERMISSIONS;
	
	public static String PLATFORM;
	
	public static String APP_BAT;
	
	private static final String PROP_FILE_CONFIG = Utils.getFilePath("config.properties").toString();
	
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
			APP_ROOT                   = properties.getProperty("app.apk.root").trim();
			APK_INSTALL                = Boolean.parseBoolean(properties.getProperty("app.apk.install"));
			AUTO_PERMISSIONS           = Boolean.parseBoolean(properties.getProperty("app.apk.autoPermissions"));
			APPIUM_AUTOMATION_NAME     = properties.getProperty("app.appium.automationName");
			APPIUM_IP                  = properties.getProperty("app.appium.ip").trim();
			APPIUM_PORT                = Integer.parseInt(properties.getProperty("app.appium.port"));
			NODEJS                     = properties.getProperty("app.appium.node");
			APPIUMJS                   = properties.getProperty("app.appium.js");
			APP_NORESET                = Boolean.parseBoolean(properties.getProperty("app.apk.noReset"));
			APP_FULLRESET              = Boolean.parseBoolean(properties.getProperty("app.apk.fullReset"));
			PLATFORM                   = properties.getProperty("app.appium.platform");
			APP_BAT                    = properties.getProperty("app.files.bat");
			HTML_REPORTER_PATH         = properties.getProperty("extent.report.path").trim();
			HTML_REPORTER_NAME         = properties.getProperty("extent.report.name").trim();
			HTML_REPORTER_TITLE        = properties.getProperty("extent.report.title").trim();
			HTML_REPORTER_PAGE_NAME    = properties.getProperty("extent.report.page.name").trim();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
