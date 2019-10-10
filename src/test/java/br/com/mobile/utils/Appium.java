package br.com.mobile.utils;

import br.com.mobile.reports.LogReport;

public class Appium {
	
	private static Command cmd = new Command();
	
	public static void install() {
		
		cmd.executeCommand("cmd /c adb devices -l", false);
		
		if(Command.getContent().contains("Error"))
			LogReport.fail("[FALHA]Node.js não está instalado!");
		
		cmd.executeCommand("cmd /c appium -version", false);
		
		cmd.executeCommand("cmd /c npm install -g appium", false);
		
	}

}
