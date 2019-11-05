package br.com.mobile.runner;

import br.com.mobile.utils.Command;
import br.com.mobile.utils.CommandAppCenter;

public class RunnerAppCenter extends CommandAppCenter {
	
	private static Command cmd = new Command();

	public static void main(String args[]) {
		
		cmd.executeCommand(getCommand(), false);	
	}
}
