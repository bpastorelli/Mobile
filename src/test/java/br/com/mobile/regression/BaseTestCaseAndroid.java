package br.com.mobile.regression;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import br.com.mobile.commons.Property;
import br.com.mobile.implementations.SetupAndroid;
import br.com.mobile.interfaces.SetupEnviroment;
import br.com.mobile.reports.LogReport;

public class BaseTestCaseAndroid {
	
	public static SetupEnviroment setup;
	
	@BeforeClass
	public static void beforeClass() throws Exception {
		
		Property.loadProperties();
		
		setup = new SetupAndroid();		
		setup.setupEnviroment();			
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
