package br.com.mobile.runner;

import br.com.mobile.actions.appcenter.CommandAppCenter;
import br.com.mobile.utils.Command;

public class RunnerAppCenter extends CommandAppCenter {
	
	private static Command cmd = new Command();

	public static void main(String args[]) {
		
		cmd.executeCommand(getCommand(), false);	
	}
}
