package br.com.mobile.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;

import br.com.mobile.commons.Property;

public class Appium {

	private static Command cmd = new Command();
	
	private static CommandLine cmdLine;

	public static void startAppium() {

		cmd.executeCommand("netstat -ano | findstr " + Property.APPIUM_PORT);
		cmd.killProcessPort();

		cmdLine = new CommandLine("C:\\Program Files\\nodejs\\node.exe");
		cmdLine.addArgument("C:\\Users\\bodl\\AppData\\Local\\Programs\\Appium\\resources\\app\\node_modules\\appium\\build\\lib\\main.js");
		cmdLine.addArgument("--address");
		cmdLine.addArgument(Property.APPIUM_IP);
		cmdLine.addArgument("--port");
		cmdLine.addArgument(Property.APPIUM_PORT.toString());

		DefaultExecuteResultHandler handler = new DefaultExecuteResultHandler();
		DefaultExecutor executor = new DefaultExecutor();
		executor.setExitValue(1);
		try {
			executor.execute(cmdLine, handler);
			Thread.sleep(20000);
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

		Utils.log("[APPIUM]Appium iniciado via Thread...");
	}

	public static void install() {

		cmd.executeCommand("adb devices -l", false);
		cmd.executeCommand("node -version", false);
		if (Command.getContent().contains("Error")) {
			Utils.log("[FALHA]O Node.js não está instalado.");
			String path = new File("src\\test\\resources\\install").getAbsolutePath();
			cmd.executeCommand("msiexec.exe /i \"" + path + " node-v10.16.3-x64.msi\" \\qn", false);
		}

		cmd.executeCommand("appium -version", false);

		if (Command.getContent().contains("operable program or batch file")) {
			Utils.log("Instalando o Appium via linha de comando...");
			cmd.executeCommand("npm install -g appium", false);
		}
	}
	
	public static void killProcessAppium() {
		
		cmd.executeCommand("netstat -ano | findstr " + Property.APPIUM_PORT);
		cmd.killProcessPort();
	}
	
	public static void stopServer() {
		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec("taskkill /F /IM node.exe");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
