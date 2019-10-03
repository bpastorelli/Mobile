package br.com.mobile.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface BasePage {
	
	/**
	 * Adiciona um elemento mapeado ao mapa de elementos.
	 * 
	 * @param name Nome que será atribuido ao elemento.
	 * @param by   Condição de busca Id, Name e etc.
	 */
	void addElement(String name, By by);
	
	/**
	 * Busca um elemento dentro do mapElements
	 * 
	 * @param name Nome do elemento no mapa
	 * @return WebElemento
	 */
	WebElement getElement(String name);
	
	/**
	 * Busca o mapeamento de um elemento a partir do key informado no mapa de elementos.
	 * 
	 * @param key
	 * @return By
	 */
	By getMap(String key);
	
	/**
	 * Busca elemento pelo By (name, id, xpath...)
	 * 
	 * @param by By.Id, By.Name, By.Xpath...
	 * @return WebElement
	 */
	WebElement findElement(By by);
	
	/**
	 * Clica um elemento pelo nome informado no mapElements
	 * 
	 * @param name Nome do elemento
	 */
	void clickElementByMapElements(String name);
	
	/**
	 * Clica no elemento a partir do By.
	 * 
	 * @param by Id, Name, Xpath...
	 */
	void clickElement(By by);
	
	/**
	 * Move o mouse para o elemento e clica.
	 * 
	 * @param name nome do elemento no mapa de elementos.
	 */
	void moveToElementClick(String name);
	
	/**
	 * Aguarda o elemento visível
	 * 
	 * @param elemento Elemento a ser aguardado
	 * @param time     Tempo limite de espera
	 * @return Retorna true caso esteja visível ou false caso não esteja visível.
	 */
	boolean waitDisplayed(WebElement elemento, int time);
	
	/**
	 * Aguarda um determinado texto ser aprensentado na tela.
	 * 
	 * @param elemento Elemento que contém o texto esperado.
	 * @param texto    Texto a ser apresentado.
	 * @param time     Tempo limite de espera.
	 * @return Retorna true caso o texto esteja presente e false caso não esteja
	 *         presente.
	 */
	boolean waitTextElement(WebElement elemento, String texto);
	
	/**
	 * Aguarda um determinado texto na página independente do elemento.
	 * 
	 * @param text
	 * @return Boolean
	 */
	boolean waitText(String text);
	
	/**
	 * Desliza a tela para a esquerda.
	 */
	void toucheActionLeft();
	
	/**
	 * Desliza a tela para a direita.
	 */
	void toucheActionRight();
	
	/**
	 * Desliza a tela para cima.
	 */	
	void touchActionTop();
	
	/**
	 * Desliza a tela para baixo.
	 */
	void touchActionDown();
	
	/**
	 * Aguarda até o tempo informado de segundos.
	 * 
	 * @param segundos
	 */
	void wait(int segundos);

}
