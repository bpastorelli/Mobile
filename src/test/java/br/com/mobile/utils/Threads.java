package br.com.mobile.utils;

public class Threads {

	Command cmd = new Command();
	
	public void startAppium() {
		
		new Thread() {
			
			@Override
			public void run() {
				
				cmd.executeCommand("appium");
			}
		}.start();
		
	}
	
}
