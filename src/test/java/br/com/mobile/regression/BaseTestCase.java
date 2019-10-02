package br.com.mobile.regression;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

import br.com.mobile.commons.Property;
import br.com.mobile.commons.SetupEnviroment;
import br.com.mobile.reports.LogReport;

public class BaseTestCase {
	
	public static WebDriver driver;
	
	public static SetupEnviroment setup = new SetupEnviroment();
	
	@BeforeClass
	public static void beforeClass() throws Exception {
		
		Property.loadProperties();
		setup.setupEnviroment();
	}
	
	@AfterClass
	public static void afterClass() throws Exception {
		
		LogReport.finalizarReport();
		setup.driverClose();
		setup.serviceStop();
	}
}
