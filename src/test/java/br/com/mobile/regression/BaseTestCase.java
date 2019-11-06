package br.com.mobile.regression;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import br.com.mobile.commons.Property;
import br.com.mobile.controllers.SetupController;
import br.com.mobile.interfaces.SetupEnviroment;
import br.com.mobile.reports.LogReport;
import br.com.mobile.utils.Appium;

public class BaseTestCase {
	
	private static SetupEnviroment setup;
	
	@BeforeClass
	public static void beforeClass() throws Exception {
		
		Property.loadProperties();
		Appium.startAppium();
		setup = SetupController.loadSetup();
	}
	
	@AfterClass
	public static void afterClass() throws Exception {
		
		try {
			
			LogReport.finalizarReport();
			setup.uninstallApp();
			setup.driverClose();
			setup.serviceStop();
		}catch(Exception e) {}
		
	}
}
