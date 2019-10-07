package br.com.mobile.interfaces;

public interface Actions {
	
	/**
	 * Validação pelo texto apresentado na tela
	 * 
	 * @param textoEsperado Texto esperado.
	 * @param mensagem Mensagem para o relatório.
	 */
	void validarTextoPagina(String textoEsperado, String mensagem);
	
	/**
	 * Clica em elemento tipo botão
	 * 
	 * @param botao Nome do botão no mapa de elementos
	 */
	void clicarBotao(String botao);
	
	/**
	 * Deslizar para cima
	 * 
	 * @param qtde Numero de vezes a deslizar
	 */
	void deslizarParaCima(int qtde);
	
	/**
	 * Deslizar para baixo
	 * 
	 * @param qtde Numero de vezes a deslizar
	 */
	void deslizarParaBaixo(int qtde);
	
	/**
	 * Deslizar para a esquerda
	 * 
	 * @param qtde Numero de vezes a deslizar
	 * @throws Exception
	 */
	void deslizarParaEsquerda(int qtde) throws Exception;
	
	/**
	 * Deslizar para a direita
	 * 
	 * @param qtde Numero de vezes a deslizar
	 * @throws Exception
	 */
	void deslizarParaDireita(int qtde) throws Exception;
	
	/**
	 * Instalar o APP
	 */
	void instalarApp();
	
	/**
	 * Desinstalar o APP
	 */
	void desinstalarApp();
	
	/**
	 * Finalizar o APP
	 * 
	 * @throws Exception
	 */
	void finalizarApp() throws Exception;

}
