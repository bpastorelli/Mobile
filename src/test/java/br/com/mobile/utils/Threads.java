package br.com.mobile.utils;

import br.com.mobile.commons.Property;

public class Threads {

	Command cmd = new Command();
	
	public void startAppium() {
		
		new Thread() {
			
			@Override
			public void run() {
				
				cmd.executeCommand("netstat -ano | findstr " + Property.APPIUM_PORT);
				cmd.killProcessPort();
				cmd.executeCommand("npm install && appium -a " + Property.APPIUM_IP + " -p " + Property.APPIUM_PORT, false);
				Utils.log("[APPIUM]Appium iniciado via Thread...");
			}
		}.start();
		
	}
	
}
