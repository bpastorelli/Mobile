package br.com.mobile.regression;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import br.com.mobile.commons.Property;
import br.com.mobile.config.ConfigPages;
import br.com.mobile.implementations.SetupAndroid;
import br.com.mobile.implementations.SetupAndroidAppCenter;
import br.com.mobile.interfaces.SetupEnviroment;
import br.com.mobile.reports.LogReport;
import br.com.mobile.utils.Command;
import br.com.mobile.utils.Utils;

public class BaseTestCase {
	
	public static SetupEnviroment setup;
	
	private static Command cmd = new Command();
	
	@BeforeClass
	public static void beforeClass() throws Exception {
		
		Property.loadProperties();
		ConfigPages.loadPages();
		
		if(Property.APP_CENTER) {
			setup = new SetupAndroidAppCenter();
			cmd.executeCommand(new File(Utils.getFilePath("files\\executar.bat")).toString(), false);
		}else {
			setup = new SetupAndroid();
			setup.setupEnviroment();			
		}

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
