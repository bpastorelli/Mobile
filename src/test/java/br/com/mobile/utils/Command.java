package br.com.mobile.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Command {

	private static String content;
	
	private static final String TASKLIST = "tasklist";

	private static final String KILL = "taskkill /F /IM ";

	private static List<String> process = new ArrayList<String>();

	/**
	 * Executa um comando de prompt comando.
	 * 
	 * @param command Comando cmd
	 */
	public void executeCommand(String command) {

		executeCommand(command, true);
	}

	/**
	 * Executa um comando de prompt comando.
	 * 
	 * @param command Comando cmd
	 * @param updateListProcess "true" atualiza lista de processos e "false" não atualiza lista de processos.
	 */
	public void executeCommand(String command, Boolean updateListProcess) {

		try {
			Utils.log("Executando o comando: " + command);
			Process process = Runtime.getRuntime().exec("cmd /c" + command);			
			logOutput(process.getInputStream(), "", updateListProcess);
			logOutput(process.getErrorStream(), "Error: ", updateListProcess);
			process.waitFor();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gera log de saída 
	 * 
	 * @param inputStream InputStream
	 * @param prefix Prefixo
	 * @param updateListProcess "true" atualiza lista de processos e "false" não atualiza lista de processos.
	 * @throws InterruptedException
	 */
	private void logOutput(InputStream inputStream, String prefix, Boolean updateListProcess) throws InterruptedException {

		Scanner scanner = new Scanner(inputStream, "UTF-8");
		while (scanner.hasNextLine()) {
			synchronized (this) {
				content = prefix + scanner.nextLine();
				Utils.log(content.trim());
				if (updateListProcess) {
					String[] item = content.split("\\s* \\s*");
					if (!Objects.equals(item[5], "0"))
						process.add(item[5]);
				}
			}
		}
		//scanner.close();
	}

	/**
	 * Verifica se um processo está em execução
	 * 
	 * @param serviceName Nome do processo
	 * @return Boolean (true = Em execuçao e false = Não está em execução)
	 * @throws Exception
	 */
	public static boolean isProcessRunning(String serviceName) throws Exception {

		Process p = Runtime.getRuntime().exec(TASKLIST);
		BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line;
		while ((line = reader.readLine()) != null) {
			if (line.contains(serviceName)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Finaliza um processo
	 * 
	 * @param serviceName Nome do processo
	 * @throws Exception
	 */
	public static void killProcess(String serviceName) throws Exception {

		Runtime.getRuntime().exec(KILL + serviceName);
	}

	/**
	 * Finaliza um processo pelo PID (Processo ID)
	 */
	public void killProcessPort() {

		if (process.size() > 0) {
			process.forEach(p -> {
				executeCommand("taskkill  /F  /PID  " + p, false);
				return;
			});
		}
	}
	
	public static String getContent() {
		
		return content;
	}
}
