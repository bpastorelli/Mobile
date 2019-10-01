package br.com.mobile.regression;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

import br.com.mobile.commons.Property;
import br.com.mobile.commons.SetupEnviroment;


public class BaseTestCase {
	
	public static WebDriver driver;
	
	public static SetupEnviroment setup = new SetupEnviroment();
	
	@BeforeClass
	public static void beforeClass() throws IOException, URISyntaxException {
		
		Property.loadProperties();
		setup.setupEnviroment();
	}
	
	@AfterClass
	public static void afterClass() throws IOException {
		
		//LogReport.finalizarReport();
		setup.driverClose();
		setup.serviceStop();
	}
}
