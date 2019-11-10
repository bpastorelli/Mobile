package br.com.mobile.actions.appcenter;

import br.com.mobile.commons.Property;
import br.com.mobile.utils.Utils;

public class CommandAppCenter {
	
	private static String cmd = null;
	
	private static String path = null;
	
	public static String getCommand() {
		
		Property.loadProperties();
		path = Utils.getDir("Mobile") + Property.APP_ROOT + Property.APP_PATH;
		
		cmd = "cd " + Utils.getDir("Mobile") + " && "
				+ "mvn -DskipTests -P prepare-for-upload package && "
				+ "appcenter test run appium --app \"bpastorelli/appCenter\" " + " --devices \"bpastorelli/samsunga7\" "
				+ " --app-path " + path + " --test-series \"master\" --locale \"en_US\" --build-dir target/upload";
		
		return cmd;
	}

}
