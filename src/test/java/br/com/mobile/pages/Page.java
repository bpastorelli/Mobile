package br.com.mobile.pages;

public interface Page {

	/**
	 * Método para verificar se um determinado texto existe na página
	 * 
	 * @param texto Texto esperado
	 * @return Boolean
	 */
	boolean textoExibidoPagina(String texto);
	
	/**
	 * Clicar no botão pelo label informado no mapa de elementos
	 * 
	 * @param label Label do botão
	 */
	void clicarBotao(String label);
	
	/**
	 * Digita um texto
	 * 
	 * @param texto Texto a ser digitado
	 */
	void digitarTexto(String name, String texto);
	
}
