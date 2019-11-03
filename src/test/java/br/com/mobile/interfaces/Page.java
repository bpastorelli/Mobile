package br.com.mobile.interfaces;

public interface Page {

	/**
	 * Método para verificar se um determinado texto existe na página
	 * 
	 * @param texto Texto esperado
	 * @return Boolean
	 */
	abstract boolean textoExibidoPagina(String texto);
	
	/**
	 * Método para verificar se um determinado texto existe na página
	 * 
	 * @param texto Texto esperado
	 * @param time Tempo de espera limite para o texto
	 * @return Boolean
	 */
	abstract boolean textoExibidoPagina(String texto, Integer time);
	
	/**
	 * Clicar no botão pelo label informado no mapa de elementos
	 * 
	 * @param label Label do botão
	 */
	abstract void clicarBotao(String label);
	
	/**
	 * Digita um texto
	 * 
	 * @param texto Texto a ser digitado
	 */
	abstract void digitarTexto(String name, String texto);
	
	/**
	 * Deslizar para a esquerda.
	 */
	abstract void deslizarParaEsquerda() throws Exception;
	
	/**
	 * Desliza para a direita
	 * 
	 * @param qtde Numero de vezes a deslizar
	 */
	abstract void deslizarParaDireia(int qtde) throws Exception;
	
	/**
	 * Deslizar para a esquerda.
	 * 
	 * @param qtde Numero de vezes a deslizar
	 */
	abstract void deslizarParaEsquerda(int qtde) throws Exception;
	
	/*
	 * Deslizar para a direita.
	 */
	abstract void deslizarParaDireia();
	
	/**
	 * Deslizar para cima
	 * 
	 * @param qtde Numero de vezes a deslizar
	 */
	abstract void deslizarParaCima(Integer qtde);
	
	/**
	 * Deslizar para baixo
	 * 
	 * @param qtde Numero de vezes a deslizar
	 */
	abstract void deslizarParaBaixo(Integer qtde);
	
	/**
	 * Deslizar para a esquerda ate que o elemento esteja visivel
	 * 
	 * @param name Nome do elemento mapeado no mapa de elementos.
	 * @param message Mensagem para o relatório
	 */
	abstract void deslizarParaEsquerdaElementoVisivel(String name);
	
	/**
	 * Deslizar para baixo ate que o elemento esteja visivel
	 * 
	 * @param name Nome do elemento mapeado no mapa de elementos.
	 * @param message Mensagem para o relatório
	 */
	abstract void deslizarParaBaixoElementoVisivel(String name);
	
	/**
	 * Deslizar para cima ate que o elemento esteja visivel
	 * 
	 * @param name Nome do elemento mapeado no mapa de elementos.
	 * @param message Mensagem para o relatório
	 */
	abstract void deslizarParaCimaElementoVisivel(String name);

	/**
	 * Deslizar para a direita ate que o elemento esteja visivel
	 * 
	 * @param name Nome do elemento mapeado no mapa de elementos.
	 * @param message Mensagem para o relatório
	 */
	abstract void deslizarParaDireitaElementoVisivel(String name);
	
	/**
	 * Deslizar para a direita até que o texto esteja visível.
	 * @param texto Texto esperado
	 */
	abstract void deslizarParaDireitaTextoVisivel(String texto);
	
	/**
	 * Deslizar para a esquerda até que o texto esteja visível.
	 * @param texto Texto esperado
	 */
	abstract void deslizarParaEsquerdaTextoVisivel(String texto);
	
	/**
	 * Deslizar para a baixo até que o texto esteja visível.
	 * @param texto Texto esperado
	 */	
	abstract void deslizarParaBaixoTextoVisivel(String texto);
	
	/**
	 * Seleciona item na lista suspensa
	 * @param name Nome do elemento
	 * @param texto Texto a ser selecionado
	 * @param message Mensagem para o relatório
	 */
	abstract void selecionarItemListaSuspensa(String name, String texto, String message);
	
	/**
	 * Funcionalidade que clica em Popup de acordo com a resposta mapeada no mapa de elementos.
	 * @param mensagem Mensagem esperada
	 * @param name Nome do elemento de resposta mapeados no mapa de elementos
	 */
	abstract void ifPopupIsPresent(String mensagem, String name);
	
	/**
	 * Funcionalidade que clica em Popup de acordo com a resposta mapeada no mapa de elementos.
	 * @param mensagem Mensagem esperada
	 * @param name Nome do elemento de resposta mapeados no mapa de elementos
	 * @param time Tempo de espera do texto
	 */
	abstract void ifPopupIsPresent(String mensagem, String name, Integer time);
	
	/**
	 * Retorna até a página que contenha o texto
	 * @param texto Texto procurado
	 */
	abstract void voltar(String texto);
	
	/**
	 * Pausa a execução
	 * @param time Tempo de pausa
	 */
	abstract void pause(Integer time);
	
}
