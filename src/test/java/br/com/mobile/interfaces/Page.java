package br.com.mobile.interfaces;

import java.util.List;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;

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
	 * Clicar no botão pelo By informado
	 * @param by id, name, xpath...
	 */
	abstract void clicarBotao(By by);
	
	/**
	 * Clicar no botão pelo elemento recebido
	 * 
	 * @param element Elemento a ser clicado
	 */	
	abstract void clicarBotao(MobileElement element);
	
	/**
	 * Digita um texto
	 * 
	 * @param texto Texto a ser digitado
	 */
	abstract void digitarTexto(String name, String texto);
	
	/**
	 * Digita um texto
	 * 
	 * @param texto Texto a ser digitado
	 * @param slow Simula a digitação dos caratres um por um.
	 */
	abstract void digitarTexto(String name, String texto, Boolean slow);
	
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
	
	/**
	 * Retorna uma lista de elementos pelo nome da lista mapeada na página
	 * @param name Nome da lista
	 * @return List<MobileElement>
	 */
	abstract List<MobileElement> retornaElementos(String name);
	
	/**
	 * Retorna lista de elementos pelo by informado
	 * @param by id, name, xpath...
	 * @return List<MobileElement>
	 */
	abstract List<MobileElement> retornaElementos(By by);
	
}
