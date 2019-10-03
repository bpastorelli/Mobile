package br.com.mobile.regression;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

import br.com.mobile.commons.Property;
import br.com.mobile.implementation.SetupAndroid;
import br.com.mobile.reports.LogReport;

public class BaseTestCase {
	
	public static WebDriver driver;
	
	public static SetupAndroid setup = new SetupAndroid();
	
	@BeforeClass
	public static void beforeClass() throws Exception {
		
		Property.loadProperties();
		setup.setupEnviroment();
	}
	
	@AfterClass
	public static void afterClass() throws Exception {
		
		LogReport.finalizarReport();
		setup.uninstallApp();
		setup.driverClose();
		setup.serviceStop();
	}
}
