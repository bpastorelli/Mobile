package br.com.mobile.runner;

import br.com.mobile.enums.PlataformaEnum;
import br.com.mobile.globals.Globals;
import br.com.mobile.utils.Command;
import br.com.mobile.utils.CommandAppCenter;

public class RunnerAppCenter extends CommandAppCenter {
	
	private static Command cmd = new Command();

	public static void main(String args[]) {
		
		Globals.PLATAFORMA_CI = PlataformaEnum.APPCENTER.get();
		cmd.executeCommand(getCommand(), false);	
	}
}
