package br.com.mobile.regression;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import br.com.mobile.commons.Property;
import br.com.mobile.enums.PlataformaEnum;
import br.com.mobile.interfaces.SetupEnviroment;
import br.com.mobile.reports.LogReport;

public class BaseTestCase {
	
	public static SetupEnviroment setup;
	
	@BeforeClass
	public static void beforeClass() throws Exception {
		
		Property.loadProperties();
		
		switch(Property.PLATFORM) {
			case "mobile":
				setup = PlataformaEnum.MOBILE.get();
				break;
			case "appCenter":
				setup = PlataformaEnum.APPCENTER.get();
				break;
		}
		
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
