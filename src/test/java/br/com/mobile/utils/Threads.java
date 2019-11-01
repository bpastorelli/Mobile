package br.com.mobile.utils;

public class Threads {

	Command cmd = new Command();
	
	public void startAppium() {
		
		new Thread() {
			
			@Override
			public void run() {
				
				cmd.executeCommand("appium -a 0.0.0.0 -p 4723");
				Utils.log("Appium iniciado via Thread...");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}.start();
		
	}
	
}
