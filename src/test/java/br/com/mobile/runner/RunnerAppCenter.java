package br.com.mobile.runner;

import java.io.File;

import br.com.mobile.commons.Property;
import br.com.mobile.utils.Command;
import br.com.mobile.utils.Utils;

public class RunnerAppCenter {
	
	private static Command cmd = new Command();
	
	public static void main(String args[]) {
		
		Property.loadProperties();
		cmd.executeCommand(new File(Utils.getFilePath(Property.APP_BAT)).toString(), false);
	}
}
