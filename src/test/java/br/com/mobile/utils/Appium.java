package br.com.mobile.utils;

public class Appium {
	
	private static Command cmd = new Command();
	
	public static void install() {
		
		cmd.executeCommand("adb devices -l", false);
		/*cmd.executeCommand("node -version", false);
		if(Command.getContent().contains("Error")) {
			Utils.log("[FALHA]O Node.js não está instalado.");
			String path = new File("src\\test\\resources\\install").getAbsolutePath(); 
			cmd.executeCommand("msiexec.exe /i \"" + path + " node-v10.16.3-x64.msi\" \\qn", false);
		}*/
		
		cmd.executeCommand("appium -version", false);
		
		if(Command.getContent().contains("operable program or batch file")) {
			Utils.log("Instalando o Appium via linha de comando...");
			cmd.executeCommand("npm install -g appium", false);
		}
	}

}
