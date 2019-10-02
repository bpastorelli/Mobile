package br.com.mobile.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Utils {
	
	private static SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss:SSS");
    
    public static String formatarNomeLog(String strLog) {
    	
    	LocalDateTime dataHoraAgora = LocalDateTime.now();
    	DateTimeFormatter formatoDataHora = DateTimeFormatter.ofPattern("dd_MM_yy_HH_mm_ss");
    	String strLogFormatado = strLog.replace(" ", "_") + "_" + dataHoraAgora.format(formatoDataHora);
    	return strLogFormatado;
    }
    
    public static String getSystemVersion() {
    	
        Runtime rt; 
        Process pr; 
        BufferedReader in;
        String line = "";
        String edition = "";
        String fullOSName = "";
        final String   SEARCH_TERM = "OS Name:";
        final String[] EDITIONS = { "Basic", "Home", 
                                    "Professional", "Enterprise" };

        try
        {
           rt = Runtime.getRuntime();
           pr = rt.exec("SYSTEMINFO");
           in = new BufferedReader(new InputStreamReader(pr.getInputStream()));

           //add all the lines into a variable
           while((line=in.readLine()) != null)
           {
              if(line.contains(SEARCH_TERM)) //found the OS you are using
              {
               //extract the full os name
                 fullOSName = line.substring(line.lastIndexOf(SEARCH_TERM) 
                 + SEARCH_TERM.length(), line.length()-1);
                 break;
              } 
           }

           //extract the edition of windows
           for(String s : EDITIONS)
           {
              if(fullOSName.trim().contains(s))
              {
                 edition = s;
              }
           }

        } catch(IOException ioe) {   
             log(ioe.getMessage());
        }
        
        return edition;
    }
    
    public static URI getFilePath(String file) {
    	
    	URI path = null;
    	
    	try {
			path = Thread.currentThread().getContextClassLoader().getResource(file).toURI();
		} catch (Exception e) {
			log("Falha ao obter o path para o arquivo " + file);
		}
    	return path;
    }
    
    public static boolean isNumeric(String strNum) {
        try {
            Double.parseDouble(strNum);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }
    
	/**
	 * Printa o log no console
	 * 
	 * message Mensagem a ser exibida
	 */
	public static synchronized void log(String message) {

		System.out.println(format.format(new Date()) + ": " + message);
	}
}
