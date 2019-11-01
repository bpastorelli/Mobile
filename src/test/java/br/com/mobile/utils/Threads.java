package br.com.mobile.utils;

import java.io.IOException;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;

import br.com.mobile.commons.Property;

public class Threads {

	Command cmd = new Command();

	public void startAppium() {

		//new Thread() {

			//@Override
			//public void run() {

				cmd.executeCommand("netstat -ano | findstr " + Property.APPIUM_PORT);
				cmd.killProcessPort();

				CommandLine cmd = new CommandLine("C:\\Program Files\\nodejs\\node.exe");
				cmd.addArgument("C:\\Users\\bodl\\AppData\\Local\\Programs\\Appium\\resources\\app\\node_modules\\appium\\build\\lib\\main.js");
				cmd.addArgument("--address");
				cmd.addArgument("0.0.0.0");
				cmd.addArgument("--port");
				cmd.addArgument("4723");

				DefaultExecuteResultHandler handler = new DefaultExecuteResultHandler();
				DefaultExecutor executor = new DefaultExecutor();
				executor.setExitValue(1);
				try {
					executor.execute(cmd, handler);
					Thread.sleep(20000);
				} catch (IOException | InterruptedException e) {
					e.printStackTrace();
				}

				Utils.log("[APPIUM]Appium iniciado via Thread...");
			}
		//}.start();

	//}

}
