package br.com.mobile.regression;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import br.com.mobile.commons.Property;
import br.com.mobile.config.ConfigPages;
import br.com.mobile.implementations.SetupAndroidAppCenter;

public class BaseTestCase {
	
	public static SetupAndroidAppCenter setup = new SetupAndroidAppCenter();
	
	@BeforeClass
	public static void beforeClass() throws Exception {
		
		Property.loadProperties();
		ConfigPages.loadPages();
		setup.setupEnviroment();
	}
	
	@AfterClass
	public static void afterClass() throws Exception {
		
		setup.getDriver().resetApp();	
		setup.driverClose();
		setup.serviceStop();
	}
}
