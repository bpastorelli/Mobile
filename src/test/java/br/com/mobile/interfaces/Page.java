package br.com.mobile.interfaces;

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
	
	/**
	 * Deslizar para a esquerda.
	 */
	void deslizarParaEsquerda() throws Exception;
	
	/**
	 * Desliza para a direita
	 * 
	 * @param qtde Numero de vezes a deslizar
	 */
	void deslizarParaDireia(int qtde) throws Exception;
	
	/**
	 * Deslizar para a esquerda.
	 * 
	 * @param qtde Numero de vezes a deslizar
	 */
	void deslizarParaEsquerda(int qtde) throws Exception;
	
	/*
	 * Deslizar para a direita.
	 */
	void deslizarParaDireia();
	
	/**
	 * Deslizar para cima
	 * 
	 * @param qtde Numero de vezes a deslizar
	 */
	void deslizarParaCima(Integer qtde);
	
	/**
	 * Deslizar para baixo
	 * 
	 * @param qtde Numero de vezes a deslizar
	 */
	void deslizarParaBaixo(Integer qtde);
	
	/**
	 * Deslizar para a esquerda ate que o elemento esteja visivel
	 * 
	 * @param name Nome do elemento mapeado no mapa de elementos.
	 * @param message Mensagem para o relatório
	 */
	void deslizarParaEsquerdaElementoVisivel(String name);

	/**
	 * Deslizar para a direita ate que o elemento esteja visivel
	 * 
	 * @param name Nome do elemento mapeado no mapa de elementos.
	 * @param message Mensagem para o relatório
	 */
	void deslizarParaDireitaElementoVisivel(String name);
	
	/**
	 * Deslizar para a direita até que o texto esteja visível.
	 * @param texto Texto esperado
	 */
	void deslizarParaDireitaTextoVisivel(String texto);
	
	/**
	 * Deslizar para a esquerda até que o texto esteja visível.
	 * @param texto Texto esperado
	 */
	void deslizarParaEsquerdaTextoVisivel(String texto);
	
	/**
	 * Deslizar para a baixo até que o texto esteja visível.
	 * @param texto Texto esperado
	 */	
	void deslizarParaBaixoTextoVisivel(String texto);
	
	/**
	 * Seleciona item na lista suspensa
	 * @param name Nome do elemento
	 * @param texto Texto a ser selecionado
	 * @param message Mensagem para o relatório
	 */
	void selecionarItemListaSuspensa(String name, String texto, String message);
	
}
